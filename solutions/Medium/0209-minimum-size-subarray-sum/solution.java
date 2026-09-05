// ──────────────────────────────────────────────────
// Problem  : 209. Minimum Size Subarray Sum
// Difficulty: Medium
// Tags     : Array, Binary Search, Sliding Window, Prefix Sum
// Link     : https://leetcode.com/problems/minimum-size-subarray-sum/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42744000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Shrink the window as long as the sum condition is satisfied
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}