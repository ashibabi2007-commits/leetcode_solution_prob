import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    // Helper class to store server attributes
    private static class Server {
        int weight;
        int index;
        long freeTime;

        public Server(int weight, int index, long freeTime) {
            this.weight = weight;
            this.index = index;
            this.freeTime = freeTime;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Min-heap for idle servers: ordered by weight, then index
        Queue<Server> freeServers = new PriorityQueue<>(
            Comparator.comparingInt((Server s) -> s.weight)
                      .thenComparingInt(s -> s.index)
        );

        // Min-heap for busy servers: ordered by freeTime, then weight, then index
        Queue<Server> busyServers = new PriorityQueue<>(
            Comparator.comparingLong((Server s) -> s.freeTime)
                      .thenComparingInt(s -> s.weight)
                      .thenComparingInt(s -> s.index)
        );

        // Initialize all servers as free at time 0
        for (int i = 0; i < n; i++) {
            freeServers.offer(new Server(servers[i], i, 0));
        }

        for (int j = 0; j < m; j++) {
            // Free up servers whose work is completed by current time 'j'
            while (!busyServers.isEmpty() && busyServers.peek().freeTime <= j) {
                freeServers.offer(busyServers.poll());
            }

            if (!freeServers.isEmpty()) {
                // Assign task to the best available free server
                Server server = freeServers.poll();
                ans[j] = server.index;
                server.freeTime = (long) j + tasks[j];
                busyServers.offer(server);
            } else {
                // If no server is free, wait for the earliest server to finish
                Server server = busyServers.poll();
                ans[j] = server.index;
                server.freeTime += tasks[j];
                busyServers.offer(server);
            }
        }

        return ans;
    }
}