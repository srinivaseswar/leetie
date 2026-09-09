// ──────────────────────────────────────────────────
// Problem  : 338. Counting Bits
// Difficulty: Easy
// Tags     : Dynamic Programming, Bit Manipulation
// Link     : https://leetcode.com/problems/counting-bits/
// Runtime  : 2 ms (beats 96%)
// Memory   : 48644000 (beats 50%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}