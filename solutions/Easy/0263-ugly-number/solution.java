// ──────────────────────────────────────────────────
// Problem  : 263. Ugly Number
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/ugly-number/
// Runtime  : 1 ms (beats 99%)
// Memory   : 42708000 (beats 15%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        
        return n == 1;
    }
}