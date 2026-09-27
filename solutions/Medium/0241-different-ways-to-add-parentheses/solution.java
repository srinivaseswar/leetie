// ──────────────────────────────────────────────────
// Problem  : 241. Different Ways to Add Parentheses
// Difficulty: Medium
// Tags     : Math, String, Dynamic Programming, Recursion, Memoization, Bracket Sequences
// Link     : https://leetcode.com/problems/different-ways-to-add-parentheses/
// Runtime  : 2 ms (beats 87%)
// Memory   : 43476000 (beats 87%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private final Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                // Divide the expression into left and right sub-expressions
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // Conquer: combine all left and right results
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        // Base case: expression is just a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }
}