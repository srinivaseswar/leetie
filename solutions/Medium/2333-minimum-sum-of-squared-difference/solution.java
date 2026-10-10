// ──────────────────────────────────────────────────
// Problem  : 2333. Minimum Sum of Squared Difference
// Difficulty: Medium
// Tags     : Array, Binary Search, Greedy, Sorting, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/minimum-sum-of-squared-difference/
// Runtime  : 9 ms (beats 84%)
// Memory   : 111988000 (beats 69%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalOps = (long) k1 + k2;
        
        // Count frequencies of each absolute difference
        int maxDiff = 0;
        int[] diffCount = new int[100005];
        
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            diffCount[d]++;
            if (d > maxDiff) {
                maxDiff = d;
            }
        }
        
        // Greedily reduce the largest differences
        for (int d = maxDiff; d > 0 && totalOps > 0; d--) {
            if (diffCount[d] == 0) continue;
            
            // Number of operations we can apply to elements with difference `d`
            long opsToApply = Math.min(totalOps, diffCount[d]);
            
            diffCount[d] -= opsToApply;
            diffCount[d - 1] += opsToApply;
            totalOps -= opsToApply;
        }
        
        // Calculate the final minimum sum of squared differences
        long minSum = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (diffCount[d] > 0) {
                minSum += (long) diffCount[d] * d * d;
            }
        }
        
        return minSum;
    }
}