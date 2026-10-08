// ──────────────────────────────────────────────────
// Problem  : 2784. Check if Array is Good
// Difficulty: Easy
// Tags     : Array, Hash Table, Sorting
// Link     : https://leetcode.com/problems/check-if-array-is-good/
// Runtime  : 1 ms (beats 93%)
// Memory   : 44816000 (beats 54%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        if (n <= 0) {
            return false;
        }

        int[] count = new int[n + 1];

        for (int num : nums) {
            // If any element exceeds n, it cannot match base[n]
            if (num > n) {
                return false;
            }
            count[num]++;
        }

        // Check if elements 1 to n - 1 appear exactly once
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) {
                return false;
            }
        }

        // Check if element n appears exactly twice
        return count[n] == 2;
    }
}