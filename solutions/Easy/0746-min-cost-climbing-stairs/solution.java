// ──────────────────────────────────────────────────
// Problem  : 746. Min Cost Climbing Stairs
// Difficulty: Easy
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/min-cost-climbing-stairs/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44364000 (beats 99%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = 0; // Min cost to reach 2 steps behind
        int prev1 = 0; // Min cost to reach 1 step behind

        for (int c : cost) {
            int curr = c + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }
}