// ──────────────────────────────────────────────────
// Problem  : 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
// Difficulty: Medium
// Tags     : Array, Hash Table, Binary Search, Dynamic Programming, Sliding Window
// Link     : https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
// Runtime  : 6 ms (beats 99%)
// Memory   : 90628000 (beats 91%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // dp[i] stores the minimum length of a valid subarray ending at or before index i
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        int minLenSoFar = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            // Shrink window if current sum exceeds target
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }
            
            // Found a valid subarray
            if (currentSum == target) {
                int currentLen = right - left + 1;
                
                // If there is a valid non-overlapping subarray before 'left'
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    minSum = Math.min(minSum, currentLen + dp[left - 1]);
                }
                
                minLenSoFar = Math.min(minLenSoFar, currentLen);
            }
            
            // Update dp array for the current index
            dp[right] = minLenSoFar;
        }
        
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}