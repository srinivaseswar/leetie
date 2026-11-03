// ──────────────────────────────────────────────────
// Problem  : 3665. Twisted Mirror Path Count
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Matrix
// Link     : https://leetcode.com/problems/twisted-mirror-path-count/
// Runtime  : 462 ms (beats 5%)
// Memory   : 280320000 (beats 85%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        // go[i][j][0] -> where you land if you try to move right from (i, j)
        // go[i][j][1] -> where you land if you try to move down from (i, j)
        int[][][] go = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Precomputing 'right' move: trying to go to (i, j + 1)
                int ni = i, nj = j + 1;
                int dir = 0; // 0 means moving right, 1 means moving down
                while (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                    if (dir == 0) {
                        // entered mirror while moving right -> turn down
                        ni = ni + 1;
                        dir = 1;
                    } else {
                        // entered mirror while moving down -> turn right
                        nj = nj + 1;
                        dir = 0;
                    }
                }
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    go[i][j][0] = ni * n + nj;
                } else {
                    go[i][j][0] = -1; // out of bounds
                }

                // Precomputing 'down' move: trying to go to (i + 1, j)
                ni = i + 1;
                nj = j;
                dir = 1; // 1 means moving down
                while (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                    if (dir == 0) {
                        ni = ni + 1;
                        dir = 1;
                    } else {
                        nj = nj + 1;
                        dir = 0;
                    }
                }
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    go[i][j][1] = ni * n + nj;
                } else {
                    go[i][j][1] = -1; // out of bounds
                }
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                // Try moving right (mapped to index 0)
                int targetR = go[i][j][0];
                if (targetR != -1) {
                    int r = targetR / n;
                    int c = targetR % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }

                // Try moving down (mapped to index 1)
                int targetD = go[i][j][1];
                if (targetD != -1) {
                    int r = targetD / n;
                    int c = targetD % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}