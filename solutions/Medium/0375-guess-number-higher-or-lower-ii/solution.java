// ──────────────────────────────────────────────────
// Problem  : 375. Guess Number Higher or Lower II
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Minimax, Game Theory
// Link     : https://leetcode.com/problems/guess-number-higher-or-lower-ii/
// Runtime  : 18 ms (beats 81%)
// Memory   : 43004000 (beats 90%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        
        // len is the length of the range [i, j]
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int x = i; x <= j; x++) {
                    int cost = x + Math.max(dp[i][x - 1], dp[x + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[1][n];
    }
}