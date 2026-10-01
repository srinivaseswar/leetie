// ──────────────────────────────────────────────────
// Problem  : 343. Integer Break
// Difficulty: Medium
// Tags     : Math, Dynamic Programming
// Link     : https://leetcode.com/problems/integer-break/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41632000 (beats 98%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int integerBreak(int n) {
       
        if (n == 2) return 1; 
        if (n == 3) return 2; 

        int product = 1;

        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        return product * n;
    }
}