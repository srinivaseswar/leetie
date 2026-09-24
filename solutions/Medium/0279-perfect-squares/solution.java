// ──────────────────────────────────────────────────
// Problem  : 279. Perfect Squares
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Breadth-First Search, Knapsack Problem, Complete Knapsack
// Link     : https://leetcode.com/problems/perfect-squares/
// Runtime  : 32 ms (beats 70%)
// Memory   : 44592000 (beats 55%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n); 
        dp[0] = 0; 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}