// ──────────────────────────────────────────────────
// Problem  : 435. Non-overlapping Intervals
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy, Sorting
// Link     : https://leetcode.com/problems/non-overlapping-intervals/
// Runtime  : 46 ms (beats 75%)
// Memory   : 116088000 (beats 9%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by their end times in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the previous one
            if (intervals[i][0] < prevEnd) {
                count++; // Remove the current interval
            } else {
                prevEnd = intervals[i][1]; // Update end time
            }
        }

        return count;
    }
}