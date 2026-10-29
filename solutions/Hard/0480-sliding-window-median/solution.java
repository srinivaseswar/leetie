// ──────────────────────────────────────────────────
// Problem  : 480. Sliding Window Median
// Difficulty: Hard
// Tags     : Array, Hash Table, Sliding Window, Heap (Priority Queue), Treap
// Link     : https://leetcode.com/problems/sliding-window-median/
// Runtime  : 2 ms (beats 0%)
// Memory   : 44824000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            int[] window = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(window);

            if (k % 2 == 1) {
                ans[i] = window[k / 2];
            } else {
                ans[i] = ((long) window[k / 2 - 1]
                        + window[k / 2]) / 2.0;
            }
        }

        return ans;
    }
}
