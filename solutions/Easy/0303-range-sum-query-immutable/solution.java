// ──────────────────────────────────────────────────
// Problem  : 303. Range Sum Query - Immutable
// Difficulty: Easy
// Tags     : Array, Design, Prefix Sum
// Link     : https://leetcode.com/problems/range-sum-query-immutable/
// Runtime  : 8 ms (beats 70%)
// Memory   : 47028000 (beats 99%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class NumArray {
    private final int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}