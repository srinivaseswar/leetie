// ──────────────────────────────────────────────────
// Problem  : 495. Teemo Attacking
// Difficulty: Easy
// Tags     : Array, Simulation
// Link     : https://leetcode.com/problems/teemo-attacking/
// Runtime  : 3 ms (beats 90%)
// Memory   : 47784000 (beats 90%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            total += Math.min(
                timeSeries[i + 1] - timeSeries[i],
                duration
            );
        }

        if (timeSeries.length > 0) {
            total += duration;
        }

        return total;
    }
}