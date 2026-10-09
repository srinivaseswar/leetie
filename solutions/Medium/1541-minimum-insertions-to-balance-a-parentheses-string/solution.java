// ──────────────────────────────────────────────────
// Problem  : 1541. Minimum Insertions to Balance a Parentheses String
// Difficulty: Medium
// Tags     : String, Stack, Greedy, Bracket Sequences
// Link     : https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// Runtime  : 12 ms (beats 33%)
// Memory   : 47408000 (beats 75%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minInsertions(String s) {
        int res = 0;       // Total insertions needed
        int openNeeded = 0; // Count of open parentheses '(' waiting for '))'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openNeeded++;
            } else { // c == ')'
                // Check if the next character is also ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Consume the consecutive ')'
                } else {
                    res++; // Insert one missing ')' to form '))'
                }

                if (openNeeded > 0) {
                    openNeeded--; // Match with an existing '('
                } else {
                    res++; // Insert a missing '(' before '))'
                }
            }
        }

        // Each remaining unmatched '(' requires two ')'
        return res + openNeeded * 2;
    }
}