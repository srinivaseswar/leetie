// ──────────────────────────────────────────────────
// Problem  : 324. Wiggle Sort II
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Greedy, Sorting, Quickselect
// Link     : https://leetcode.com/problems/wiggle-sort-ii/
// Runtime  : 1 ms (beats 0%)
// Memory   : 43160000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        int left = (n - 1) / 2; // End of smaller half
        int right = n - 1;      // End of larger half
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                nums[i] = sorted[right--];
            } else {
                nums[i] = sorted[left--];
            }
        }
    }
}