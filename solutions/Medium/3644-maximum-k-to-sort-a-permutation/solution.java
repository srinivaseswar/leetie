// ──────────────────────────────────────────────────
// Problem  : 3644. Maximum K to Sort a Permutation
// Difficulty: Medium
// Tags     : Array, Bit Manipulation
// Link     : https://leetcode.com/problems/maximum-k-to-sort-a-permutation/
// Runtime  : 3 ms (beats 16%)
// Memory   : 109640000 (beats 95%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int sortPermutation(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }
        // If all elements are already in their correct places, return 0
        return (k == -1) ? 0 : k;
    }
}