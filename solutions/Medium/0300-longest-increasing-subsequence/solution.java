// ──────────────────────────────────────────────────
// Problem  : 300. Longest Increasing Subsequence
// Difficulty: Medium
// Tags     : Array, Binary Search, Dynamic Programming, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/longest-increasing-subsequence/
// Runtime  : 38 ms (beats 64%)
// Memory   : 46068000 (beats 71%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}