// ──────────────────────────────────────────────────
// Problem  : 470. Implement Rand10() Using Rand7()
// Difficulty: Medium
// Tags     : Math, Rejection Sampling, Randomized, Probability and Statistics
// Link     : https://leetcode.com/problems/implement-rand10-using-rand7/
// Runtime  : 7 ms (beats 11%)
// Memory   : 51324000 (beats 84%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution extends SolBase {
    public int rand10() {
        while (true) {
            // Step 1: Generate a uniform number from 1 to 49
            int row = rand7();
            int col = rand7();
            int idx = (row - 1) * 7 + col;
            
            // Step 2: Accept if within the range [1, 40], otherwise reject and retry
            if (idx <= 40) {
                return (idx - 1) % 10 + 1;
            }
        }
    }
}