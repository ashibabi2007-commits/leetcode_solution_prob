import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requestCount = new int[k];
        
        // Min-heap to store busy servers: stores int[] {end_time, server_id}
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // TreeSet to keep track of currently available (free) servers
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        
        for (int i = 0; i < arrival.length; i++) {
            int startTime = arrival[i];
            int endTime = startTime + load[i];
            
            // 1. Free up servers whose tasks have finished by the current arrival time
            while (!busy.isEmpty() && busy.peek()[0] <= startTime) {
                free.add(busy.poll()[1]);
            }
            
            // 2. If no servers are available, drop the request
            if (free.isEmpty()) {
                continue;
            }
            
            // 3. Find the preferred server using ceiling() for index >= (i % k)
            Integer server = free.ceiling(i % k);
            
            // If no server >= (i % k) is available, wrap around to the first available server
            if (server == null) {
                server = free.first();
            }
            
            // 4. Assign the request to the chosen server
            requestCount[server]++;
            busy.offer(new int[] {endTime, server});
            free.remove(server);
        }
        
        // 5. Find the maximum number of requests handled by any server
        int maxRequests = 0;
        for (int count : requestCount) {
            maxRequests = Math.max(maxRequests, count);
        }
        
        // 6. Collect all servers that match the max workload
        List<Integer> busiestServersList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                busiestServersList.add(i);
            }
        }
        
        return busiestServersList;
    }
}