// ──────────────────────────────────────────────────
// Problem  : 268. Missing Number
// Difficulty: Easy
// Tags     : Array, Hash Table, Math, Binary Search, Bit Manipulation, Sorting
// Link     : https://leetcode.com/problems/missing-number/
// Runtime  : 0 ms (beats 100%)
// Memory   : 47156000 (beats 82%)
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