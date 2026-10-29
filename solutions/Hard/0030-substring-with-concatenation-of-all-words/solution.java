// ──────────────────────────────────────────────────
// Problem  : 30. Substring with Concatenation of All Words
// Difficulty: Hard
// Tags     : Hash Table, String, Sliding Window
// Link     : https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// Runtime  : 12 ms (beats 53%)
// Memory   : 46904000 (beats 84%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        Map<String, Integer> target = new HashMap<>();

        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (!target.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                while (window.get(word) > target.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    count--;
                    left += wordLen;
                }

                if (count == wordCount) {
                    result.add(left);

                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    count--;
                    left += wordLen;
                }
            }
        }

        return result;
    }
}
