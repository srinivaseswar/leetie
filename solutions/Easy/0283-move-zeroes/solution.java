// ──────────────────────────────────────────────────
// Problem  : 283. Move Zeroes
// Difficulty: Easy
// Tags     : Array, Two Pointers
// Link     : https://leetcode.com/problems/move-zeroes/
// Runtime  : 1 ms (beats 100%)
// Memory   : 47988000 (beats 20%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Shift all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill remaining positions with zeroes
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}