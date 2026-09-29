// ──────────────────────────────────────────────────
// Problem  : 224. Basic Calculator
// Difficulty: Hard
// Tags     : Math, String, Stack, Recursion
// Link     : https://leetcode.com/problems/basic-calculator/
// Runtime  : 10 ms (beats 82%)
// Memory   : 46460000 (beats 56%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 for '+', -1 for '-'

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                // Reset result and sign for the inner sub-expression
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;

                // Multiply current sub-expression result by sign preceding the parenthesis
                result *= stack.pop(); // sign
                // Add the result before parenthesis
                result += stack.pop(); // previous result
            }
        }

        // Add any remaining trailing number
        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}