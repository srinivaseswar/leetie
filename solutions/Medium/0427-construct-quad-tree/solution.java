// ──────────────────────────────────────────────────
// Problem  : 427. Construct Quad Tree
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Tree, Matrix
// Link     : https://leetcode.com/problems/construct-quad-tree/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42816000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);
    }

    private Node buildTree(int[][] grid, int r, int c, int size) {
        if (isAllSame(grid, r, c, size)) {
            return new Node(grid[r][c] == 1, true);
        }

        int half = size / 2;
        Node topLeft = buildTree(grid, r, c, half);
        Node topRight = buildTree(grid, r, c + half, half);
        Node bottomLeft = buildTree(grid, r + half, c, half);
        Node bottomRight = buildTree(grid, r + half, c + half, half);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isAllSame(int[][] grid, int r, int c, int size) {
        int val = grid[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}