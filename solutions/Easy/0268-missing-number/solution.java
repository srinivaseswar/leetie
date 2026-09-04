// ──────────────────────────────────────────────────
// Problem  : 268. Missing Number
// Difficulty: Easy
// Tags     : Array, Hash Table, Math, Binary Search, Bit Manipulation, Sorting
// Link     : https://leetcode.com/problems/missing-number/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42468000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        
        return missing;
    }
}