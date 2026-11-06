import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // Sort logs by timestamp
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Create an array of wrapper objects to store queries with their original indices
        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = i;         // original index
            sortedQueries[i][1] = queries[i]; // query time
        }

        // Sort queries by their time values
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ans = new int[qLen];
        Map<Integer, Integer> activeServers = new HashMap<>();

        int j = 0; // Left pointer for logs falling out of the window
        int k = 0; // Right pointer for logs entering the window

        for (int i = 0; i < qLen; i++) {
            int originalIdx = sortedQueries[i][0];
            int qTime = sortedQueries[i][1];
            int windowStart = qTime - x;
            int windowEnd = qTime;

            // Expand window: include all logs with time <= windowEnd
            while (k < logs.length && logs[k][1] <= windowEnd) {
                int serverId = logs[k][0];
                activeServers.put(serverId, activeServers.getOrDefault(serverId, 0) + 1);
                k++;
            }

            // Shrink window: exclude logs with time < windowStart
            while (j < logs.length && logs[j][1] < windowStart) {
                int serverId = logs[j][0];
                int count = activeServers.get(serverId) - 1;
                if (count == 0) {
                    activeServers.remove(serverId);
                } else {
                    activeServers.put(serverId, count);
                }
                j++;
            }

            // Inactive servers = total servers (n) - servers that got at least one request
            ans[originalIdx] = n - activeServers.size();
        }

        return ans;
    }
}