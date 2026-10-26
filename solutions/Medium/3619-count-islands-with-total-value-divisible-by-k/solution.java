// ──────────────────────────────────────────────────
// Problem  : 3619. Count Islands With Total Value Divisible by K
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
// Link     : https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/
// Runtime  : 28 ms (beats 24%)
// Memory   : 102192000 (beats 95%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int validIslands = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    // BFS to traverse the island
                    long currentIslandSum = 0;
                    java.util.Queue<int[]> queue = new java.util.LinkedList<>();
                    
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int r = cell[0];
                        int c = cell[1];
                        currentIslandSum += grid[r][c];
                        
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && 
                                grid[nr][nc] > 0 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    
                    if (currentIslandSum % k == 0) {
                        validIslands++;
                    }
                }
            }
        }
        
        return validIslands;
    }
}