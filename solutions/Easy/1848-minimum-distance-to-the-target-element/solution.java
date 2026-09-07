// ──────────────────────────────────────────────────
// Problem  : 1848. Minimum Distance to the Target Element
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/minimum-distance-to-the-target-element/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44960000 (beats 73%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int dist = Math.abs(i - start);
                minDistance = Math.min(minDistance, dist);
                
                // If we reach distance 0, we can stop early as distance cannot be negative
                if (minDistance == 0) {
                    return 0;
                }
            }
        }

        return minDistance;
    }
}