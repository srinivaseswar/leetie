// ──────────────────────────────────────────────────
// Problem  : 494. Target Sum
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Backtracking, Knapsack Problem, 0-1 Knapsack
// Link     : https://leetcode.com/problems/target-sum/
// Runtime  : 2 ms (beats 100%)
// Memory   : 42548000 (beats 94%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        int s = (sum + target) / 2;

        int[] dp = new int[s + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = s; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[s];
    }
}