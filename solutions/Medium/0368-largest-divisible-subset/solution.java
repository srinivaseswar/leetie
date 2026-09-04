// ──────────────────────────────────────────────────
// Problem  : 368. Largest Divisible Subset
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming, Sorting
// Link     : https://leetcode.com/problems/largest-divisible-subset/
// Runtime  : 17 ms (beats 63%)
// Memory   : 45156000 (beats 60%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        
        Arrays.sort(nums);
        
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxIdx = 0;
        int maxSize = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIdx = i;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (maxIdx != -1) {
            result.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }
        
        return result;
    }
}