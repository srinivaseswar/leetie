// ──────────────────────────────────────────────────
// Problem  : 3727. Maximum Alternating Sum of Squares
// Difficulty: Medium
// Tags     : Array, Greedy, Sorting
// Link     : https://leetcode.com/problems/maximum-alternating-sum-of-squares/
// Runtime  : 33 ms (beats 68%)
// Memory   : 134828000 (beats 51%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            squares[i] = val * val;
        }
        
        Arrays.sort(squares);
        
        long maxScore = 0;
        // The first n / 2 elements (smaller values) are subtracted
        // The remaining elements (larger values) are added
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            if (i < mid) {
                maxScore -= squares[i];
            } else {
                maxScore += squares[i];
            }
        }
        
        return maxScore;
    }
}