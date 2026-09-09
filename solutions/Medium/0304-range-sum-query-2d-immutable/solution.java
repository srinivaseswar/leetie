// ──────────────────────────────────────────────────
// Problem  : 304. Range Sum Query 2D - Immutable
// Difficulty: Medium
// Tags     : Array, Design, Matrix, Prefix Sum
// Link     : https://leetcode.com/problems/range-sum-query-2d-immutable/
// Runtime  : 101 ms (beats 80%)
// Memory   : 142148000 (beats 36%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class NumMatrix {
    private final int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m + 1][n + 1];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                prefix[r + 1][c + 1] = matrix[r][c] 
                                    + prefix[r][c + 1] 
                                    + prefix[r + 1][c] 
                                    - prefix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] 
             - prefix[row1][col2 + 1] 
             - prefix[row2 + 1][col1] 
             + prefix[row1][col1];
    }
}