// ──────────────────────────────────────────────────
// Problem  : 1882. Process Tasks Using Servers
// Difficulty: Medium
// Tags     : Array, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/process-tasks-using-servers/
// Runtime  : 679 ms (beats 5%)
// Memory   : 178596000 (beats 12%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Free servers priority queue: ordered by weight first, then by index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
            Comparator.comparingInt((int[] s) -> s[0])
                      .thenComparingInt(s -> s[1])
        );

        // Populate free servers with {weight, index}
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        // Busy servers priority queue: ordered by available time, then weight, then index
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(
            Comparator.comparingInt((int[] s) -> s[0])
                      .thenComparingInt(s -> s[1])
                      .thenComparingInt(s -> s[2])
        );

        int time = 0;
        for (int j = 0; j < m; j++) {
            // Time cannot be less than the current task insertion time `j`
            time = Math.max(time, j);

            // If there are no free servers available, jump time to when the next busy server finishes
            if (freeServers.isEmpty()) {
                time = Math.max(time, busyServers.peek()[0]);
            }

            // Release all servers that finish at or before the current `time`
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
                int[] busyServer = busyServers.poll();
                // busyServer format: {availableTime, weight, index}
                freeServers.offer(new int[]{busyServer[1], busyServer[2]});
            }

            // Assign the current task `j` to the best available free server
            int[] bestServer = freeServers.poll();
            int serverWeight = bestServer[0];
            int serverIndex = bestServer[1];

            ans[j] = serverIndex;
            
            // Push the server into the busy queue with its new release time
            busyServers.offer(new int[]{time + tasks[j], serverWeight, serverIndex});
        }

        return ans;
    }
}