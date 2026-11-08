// ──────────────────────────────────────────────────
// Problem  : 1267. Count Servers that Communicate
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix, Counting
// Link     : https://leetcode.com/problems/count-servers-that-communicate/
// Runtime  : 2 ms (beats 100%)
// Memory   : 54936000 (beats 59%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}