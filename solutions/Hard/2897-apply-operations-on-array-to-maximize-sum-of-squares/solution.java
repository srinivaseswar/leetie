// ──────────────────────────────────────────────────
// Problem  : 2897. Apply Operations on Array to Maximize Sum of Squares
// Difficulty: Hard
// Tags     : Array, Hash Table, Greedy, Bit Manipulation
// Link     : https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
// Runtime  : 67 ms (beats 15%)
// Memory   : 80024000 (beats 100%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[32];
        
        // Count the frequency of each bit across all numbers
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        long totalSum = 0;
        long MOD = 1_000_000_007;
        
        // Greedily construct the top k largest numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 32; bit++) {
                if (bitCount[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCount[bit]--;
                }
            }
            totalSum = (totalSum + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSum;
    }
}