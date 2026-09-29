// ──────────────────────────────────────────────────
// Problem  : 2267.  Check if There Is a Valid Parentheses String Path
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Matrix, Bracket Sequences
// Link     : https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/
// Runtime  : 6 ms (beats 82%)
// Memory   : 74388000 (beats 68%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Path length is m + n - 1. A valid parentheses string must have an even length.
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Must start with '(' and end with ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // Maximum possible open parentheses balance is (m + n) / 2
        int maxBalance = (m + n) / 2;
        memo = new Boolean[m][n][maxBalance + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance) {
        // Update balance for current cell
        balance += (grid[r][c] == '(') ? 1 : -1;

        // Invalid state: negative balance or balance exceeds maximum possible remaining needed
        if (balance < 0 || balance > (m + n) / 2) {
            return false;
        }

        // Reached destination cell
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        // Check memoization table
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean found = false;

        // Move Right
        if (c + 1 < n) {
            found = dfs(grid, r, c + 1, balance);
        }

        // Move Down
        if (!found && r + 1 < m) {
            found = dfs(grid, r + 1, c, balance);
        }

        return memo[r][c][balance] = found;
    }
}