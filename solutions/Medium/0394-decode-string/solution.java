// ──────────────────────────────────────────────────
// Problem  : 394. Decode String
// Difficulty: Medium
// Tags     : String, Stack, Recursion
// Link     : https://leetcode.com/problems/decode-string/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42780000 (beats 75%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                
                // Reset for the content inside the bracket
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder prevString = stringStack.pop();
                int repeatCount = countStack.pop();
                
                for (int i = 0; i < repeatCount; i++) {
                    prevString.append(currentString);
                }
                currentString = prevString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}