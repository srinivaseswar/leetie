// ──────────────────────────────────────────────────
// Problem  : 486. Predict the Winner
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming, Recursion, Minimax, Game Theory, Zero-Sum Game
// Link     : https://leetcode.com/problems/predict-the-winner/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42160000 (beats 94%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return scoreDiff(nums, 0, n - 1, memo) >= 0;
    }
    
    private int scoreDiff(int[] nums, int i, int j, Integer[][] memo) {
        if (i == j) {
            return nums[i];
        }
        
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        int pickLeft = nums[i] - scoreDiff(nums, i + 1, j, memo);
        int pickRight = nums[j] - scoreDiff(nums, i, j - 1, memo);
        
        return memo[i][j] = Math.max(pickLeft, pickRight);
    }
}