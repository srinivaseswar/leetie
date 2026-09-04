// ──────────────────────────────────────────────────
// Problem  : 436. Find Right Interval
// Difficulty: Medium
// Tags     : Array, Binary Search, Sorting
// Link     : https://leetcode.com/problems/find-right-interval/
// Runtime  : 11 ms (beats 97%)
// Memory   : 54376000 (beats 13%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] starts = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; // Start value
            starts[i][1] = i;               // Original index
        }
        
        // Sort starts array by start values
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int target = intervals[i][1]; // Current end value
            int idx = binarySearch(starts, target);
            result[i] = idx;
        }
        
        return result;
    }
    
    private int binarySearch(int[][] starts, int target) {
        int low = 0, high = starts.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (starts[mid][0] >= target) {
                ans = starts[mid][1]; // Candidate found, try searching left for smaller start
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
}