// ──────────────────────────────────────────────────
// Problem  : 462. Minimum Moves to Equal Array Elements II
// Difficulty: Medium
// Tags     : Array, Math, Sorting
// Link     : https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
// Runtime  : 10 ms (beats 84%)
// Memory   : 46672000 (beats 87%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMoves2(int[] nums) {
        java.util.Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}