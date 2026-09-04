// ──────────────────────────────────────────────────
// Problem  : 354. Russian Doll Envelopes
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Sorting, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/russian-doll-envelopes/
// Runtime  : 40 ms (beats 70%)
// Memory   : 99404000 (beats 58%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        // Sort: ascending width, descending height for equal widths
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });
        
        // Find LIS on heights
        int[] tails = new int[envelopes.length];
        int len = 0;
        
        for (int[] env : envelopes) {
            int height = env[1];
            int idx = Arrays.binarySearch(tails, 0, len, height);
            
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            tails[idx] = height;
            if (idx == len) {
                len++;
            }
        }
        
        return len;
    }
}