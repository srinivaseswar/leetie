// ──────────────────────────────────────────────────
// Problem  : 3970. Shortest Path With At Most K Consecutive Identical Characters
// Difficulty: Medium
// Tags     : String, Graph Theory, Heap (Priority Queue), Shortest Path
// Link     : https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/
// Runtime  : 69 ms (beats 52%)
// Memory   : 274464000 (beats 17%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: u -> list of [v, weight]
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        // Priority queue stores: [total_weight, node, consecutive_count]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        
        // dist[u][count] stores the minimum weight to reach node u with 'count' consecutive identical characters
        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        // Starting at node 0 with count = 1
        int startNode = 0;
        int startCount = 1;
        dist[startNode][startCount] = 0;
        pq.offer(new long[]{0, startNode, startCount});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            if (d > dist[u][count]) continue;

            // If we reached the destination node n - 1, return the total weight
            if (u == n - 1) {
                return (int) d;
            }

            char charU = labels.charAt(u);

            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                char charV = labels.charAt(v);

                int nextCount;
                if (charU == charV) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                // Skip if it exceeds the limit k
                if (nextCount > k) continue;

                if (d + weight < dist[v][nextCount]) {
                    dist[v][nextCount] = d + weight;
                    pq.offer(new long[]{d + weight, v, nextCount});
                }
            }
        }

        // Check all valid counts at node n - 1
        long minWeight = Long.MAX_VALUE;
        for (int c = 1; c <= k; c++) {
            minWeight = Math.min(minWeight, dist[n - 1][c]);
        }

        return minWeight == Long.MAX_VALUE ? -1 : (int) minWeight;
    }
}