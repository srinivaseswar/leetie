// ──────────────────────────────────────────────────
// Problem  : 477. Total Hamming Distance
// Difficulty: Medium
// Tags     : Array, Math, Bit Manipulation
// Link     : https://leetcode.com/problems/total-hamming-distance/
// Runtime  : 4 ms (beats 98%)
// Memory   : 47648000 (beats 80%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;

        for (int bit = 0; bit < 32; bit++) {
            int ones = 0;

            for (int num : nums) {
                ones += (num >> bit) & 1;
            }

            int zeros = n - ones;
            total += ones * zeros;
        }

        return total;
    }
}
