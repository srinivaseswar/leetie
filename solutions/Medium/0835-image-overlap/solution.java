// ──────────────────────────────────────────────────
// Problem  : 835. Image Overlap
// Difficulty: Medium
// Tags     : Array, Matrix
// Link     : https://leetcode.com/problems/image-overlap/
// Runtime  : 185 ms (beats 22%)
// Memory   : 47912000 (beats 9%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        // Store coordinates of all 1s
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) list1.add(new int[]{r, c});
                if (img2[r][c] == 1) list2.add(new int[]{r, c});
            }
        }

        // Map to count frequencies of each unique shift vector (dr, dc)
        Map<String, Integer> countMap = new HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];
                
                String key = dr + "," + dc;
                int count = countMap.getOrDefault(key, 0) + 1;
                countMap.put(key, count);
                
                maxOverlap = Math.max(maxOverlap, count);
            }
        }

        return maxOverlap;
    }
}