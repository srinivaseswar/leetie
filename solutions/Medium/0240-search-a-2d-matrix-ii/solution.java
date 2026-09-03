// ──────────────────────────────────────────────────
// Problem  : 240. Search a 2D Matrix II
// Difficulty: Medium
// Tags     : Array, Binary Search, Divide and Conquer, Matrix
// Link     : https://leetcode.com/problems/search-a-2d-matrix-ii/
// Runtime  : 3 ms (beats 87%)
// Memory   : 48020000 (beats 84%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        // Start from top-right corner
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // Target is smaller, move left
            } else {
                row++; // Target is larger, move down
            }
        }

        return false;
    }
}