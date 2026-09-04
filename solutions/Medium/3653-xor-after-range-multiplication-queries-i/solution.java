// ──────────────────────────────────────────────────
// Problem  : 3653. XOR After Range Multiplication Queries I
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Simulation, Prefix Sum
// Link     : https://leetcode.com/problems/xor-after-range-multiplication-queries-i/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42224000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;
        
        // Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int) ((1L * nums[idx] * v) % MOD);
            }
        }
        
        // Compute XOR sum of final elements
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        
        return xorSum;
    }
}