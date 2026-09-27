// ──────────────────────────────────────────────────
// Problem  : 1190. Reverse Substrings Between Each Pair of Parentheses
// Difficulty: Medium
// Tags     : String, Stack, Bracket Sequences
// Link     : https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
// Runtime  : 25 ms (beats 13%)
// Memory   : 47048000 (beats 18%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                // Collect characters inside current parentheses
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                // Pop the matching '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // Push reversed substring back onto the stack
                for (int i = 0; i < sb.length(); i++) {
                    stack.push(sb.charAt(i));
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}