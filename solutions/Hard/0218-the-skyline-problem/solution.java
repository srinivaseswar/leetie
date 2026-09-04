// ──────────────────────────────────────────────────
// Problem  : 218. The Skyline Problem
// Difficulty: Hard
// Tags     : Array, Divide and Conquer, Binary Indexed Tree, Segment Tree, Sweep Line, Sorting, Heap (Priority Queue), Ordered Set
// Link     : https://leetcode.com/problems/the-skyline-problem/
// Runtime  : 32 ms (beats 66%)
// Memory   : 53728000 (beats 61%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // Start event
            events.add(new int[]{b[1], b[2]});  // End event
        }
        
        // Sort events
        events.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        List<List<Integer>> result = new ArrayList<>();
        // Max-heap implementation via TreeMap: height -> count
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 1); // Ground level
        
        int prevMaxHeight = 0;
        
        for (int[] event : events) {
            int x = event[0];
            int h = event[1];
            
            if (h < 0) {
                // Add building height
                heightMap.put(-h, heightMap.getOrDefault(-h, 0) + 1);
            } else {
                // Remove building height
                int count = heightMap.get(h);
                if (count == 1) {
                    heightMap.remove(h);
                } else {
                    heightMap.put(h, count - 1);
                }
            }
            
            int currentMaxHeight = heightMap.lastKey();
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }
        
        return result;
    }
}