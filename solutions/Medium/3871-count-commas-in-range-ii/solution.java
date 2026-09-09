// ──────────────────────────────────────────────────
// Problem  : 3871. Count Commas in Range II
// Difficulty: Medium
// Tags     : Math
// Link     : https://leetcode.com/problems/count-commas-in-range-ii/
// Runtime  : 1 ms (beats 99%)
// Memory   : 42844000 (beats 24%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long threshold = 1000;
        
        while (n >= threshold) {
            totalCommas += (n - threshold + 1);
            // Avoid overflow when multiplying by 1000 near Long.MAX_VALUE limits
            if (threshold > Long.MAX_VALUE / 1000) {
                break;
            }
            threshold *= 1000;
        }
        
        return totalCommas;
    }
}