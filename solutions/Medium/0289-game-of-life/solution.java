// ──────────────────────────────────────────────────
// Problem  : 289. Game of Life
// Difficulty: Medium
// Tags     : Array, Matrix, Simulation
// Link     : https://leetcode.com/problems/game-of-life/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43056000 (beats 80%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 8 direction vectors for neighboring cells
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        // Step 1: Traverse the board and mark future states using intermediate values
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int liveNeighbors = 0;

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Check bounds and if the neighbor was originally live (1 or 3)
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (board[nr][nc] == 1 || board[nr][nc] == 3) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply Game of Life rules
                if (board[r][c] == 1) {
                    // Rule 1 & 3: Live cell stays live only with 2 or 3 live neighbors
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        board[r][c] = 3; // Live -> Live
                    }
                    // Else stays 1 (Live -> Dead)
                } else {
                    // Rule 4: Dead cell becomes live with exactly 3 live neighbors
                    if (liveNeighbors == 3) {
                        board[r][c] = 2; // Dead -> Live
                    }
                }
            }
        }

        // Step 2: Final pass to map state values back to 0 or 1
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] /= 2; // 0,1 become 0; 2,3 become 1
            }
        }
    }
}