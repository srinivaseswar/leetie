// ──────────────────────────────────────────────────
// Problem  : 326. Power of Three
// Difficulty: Easy
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/power-of-three/
// Runtime  : 8 ms (beats 93%)
// Memory   : 45976000 (beats 66%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPowerOfThree(int n) {
        // 3^19 is the largest power of 3 that fits within a 32-bit signed integer
        return n > 0 && 1162261467 % n == 0;
    }
}