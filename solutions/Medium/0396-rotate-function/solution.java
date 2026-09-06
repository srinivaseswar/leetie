// ──────────────────────────────────────────────────
// Problem  : 396. Rotate Function
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming
// Link     : https://leetcode.com/problems/rotate-function/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42604000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f0 = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += (long) i * nums[i];
        }

        long maxF = f0;
        long currentF = f0;

        for (int k = 1; k < n; k++) {
            currentF = currentF + sum - (long) n * nums[n - k];
            maxF = Math.max(maxF, currentF);
        }

        return (int) maxF;
    }
}