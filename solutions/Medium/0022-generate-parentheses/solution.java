// ──────────────────────────────────────────────────
// Problem  : 22. Generate Parentheses
// Difficulty: Medium
// Tags     : String, Dynamic Programming, Backtracking, Bracket Sequences
// Link     : https://leetcode.com/problems/generate-parentheses/
// Runtime  : 1 ms (beats 86%)
// Memory   : 44400000 (beats 79%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: if the string has reached the maximum length (2 * n)
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Add an open parenthesis if we haven't reached n open parentheses
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Add a close parenthesis if we have more open than close parentheses
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}