// ──────────────────────────────────────────────────
// Problem  : 290. Word Pattern
// Difficulty: Easy
// Tags     : Hash Table, String
// Link     : https://leetcode.com/problems/word-pattern/
// Runtime  : 1 ms (beats 84%)
// Memory   : 43008000 (beats 6%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Set<String> seenWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (seenWords.contains(word)) {
                    return false;
                }
                charToWord.put(c, word);
                seenWords.add(word);
            }
        }

        return true;
    }
}