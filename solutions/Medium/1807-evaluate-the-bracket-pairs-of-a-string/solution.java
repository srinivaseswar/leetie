// ──────────────────────────────────────────────────
// Problem  : 1807. Evaluate the Bracket Pairs of a String
// Difficulty: Medium
// Tags     : Array, Hash Table, String
// Link     : https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
// Runtime  : 37 ms (beats 56%)
// Memory   : 90636000 (beats 82%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Store knowledge pairs in a HashMap for O(1) lookup
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;

        // Step 2: Traverse string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                insideBracket = true;
            } else if (c == ')') {
                insideBracket = false;
                String keyStr = key.toString();
                result.append(map.getOrDefault(keyStr, "?"));
                key.setLength(0); // Reset key buffer
            } else if (insideBracket) {
                key.append(c);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}