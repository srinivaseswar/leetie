// ──────────────────────────────────────────────────
// Problem  : 2747. Count Zero Request Servers
// Difficulty: Medium
// Tags     : Array, Hash Table, Sliding Window, Sorting
// Link     : https://leetcode.com/problems/count-zero-request-servers/
// Runtime  : 30 ms (beats 82%)
// Memory   : 134484000 (beats 80%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        // Store queries with their original indices: {time, original_index}
        int[][] indexedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            indexedQueries[i][0] = queries[i];
            indexedQueries[i][1] = i;
        }

        // Sort queries by time
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // Sort logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ans = new int[m];
        int[] serverCount = new int[n + 1]; // Frequency of requests per server
        int activeServers = 0;             // Number of servers that received at least 1 request
        
        int logLeft = 0;
        int logRight = 0;
        int totalLogs = logs.length;

        for (int i = 0; i < m; i++) {
            int qTime = indexedQueries[i][0];
            int origIdx = indexedQueries[i][1];
            int windowStart = qTime - x;
            int windowEnd = qTime;

            // Add logs that fall within or before the windowEnd
            while (logRight < totalLogs && logs[logRight][1] <= windowEnd) {
                int serverId = logs[logRight][0];
                if (serverCount[serverId] == 0) {
                    activeServers++;
                }
                serverCount[serverId]++;
                logRight++;
            }

            // Remove logs that fall strictly before windowStart
            while (logLeft < totalLogs && logs[logLeft][1] < windowStart) {
                int serverId = logs[logLeft][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--;
                }
                logLeft++;
            }

            // Servers with zero requests = total servers (n) - active servers
            ans[origIdx] = n - activeServers;
        }

        return ans;
    }
}