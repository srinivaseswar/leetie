// ──────────────────────────────────────────────────
// Problem  : 378. Kth Smallest Element in a Sorted Matrix
// Difficulty: Medium
// Tags     : Array, Binary Search, Sorting, Heap (Priority Queue), Matrix
// Link     : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42648000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(matrix, mid, n);
            
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    private int countLessOrEqual(int[][] matrix, int target, int n) {
        int count = 0;
        int row = n - 1;
        int col = 0;
        
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }
        
        return count;
    }
}