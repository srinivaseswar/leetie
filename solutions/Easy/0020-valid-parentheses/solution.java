// ──────────────────────────────────────────────────
// Problem  : 20. Valid Parentheses
// Difficulty: Easy
// Tags     : String, Stack, Bracket Sequences
// Link     : https://leetcode.com/problems/valid-parentheses/
// Runtime  : 3 ms (beats 86%)
// Memory   : 43448000 (beats 26%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}