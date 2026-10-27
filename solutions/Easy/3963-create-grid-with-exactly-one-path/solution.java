// ──────────────────────────────────────────────────
// Problem  : 3963. Create Grid With Exactly One Path
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/create-grid-with-exactly-one-path/
// Runtime  : 4 ms (beats 24%)
// Memory   : 45908000 (beats 91%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String[] createGrid(int m, int n) {
        StringBuilder[] grid = new StringBuilder[m];
        
        // Initialize every row with obstacles '#'
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('#');
            }
            grid[i] = sb;
        }
        
        // Create a single valid path: go all the way right on the top row (row 0), 
        // then all the way down on the last column (column n - 1).
        for (int j = 0; j < n; j++) {
            grid[0].setCharAt(j, '.');
        }
        for (int i = 0; i < m; i++) {
            grid[i].setCharAt(n - 1, '.');
        }
        
        // Convert to String[]
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = grid[i].toString();
        }
        
        return result;
    }
}