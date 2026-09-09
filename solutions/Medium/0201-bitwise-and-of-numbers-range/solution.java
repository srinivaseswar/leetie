// ──────────────────────────────────────────────────
// Problem  : 201. Bitwise AND of Numbers Range
// Difficulty: Medium
// Tags     : Bit Manipulation
// Link     : https://leetcode.com/problems/bitwise-and-of-numbers-range/
// Runtime  : 3 ms (beats 100%)
// Memory   : 45984000 (beats 37%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0;
        
        // Find the common prefix of left and right
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }
        
        // Restore the prefix to its original position
        return left << shiftCount;
    }
}