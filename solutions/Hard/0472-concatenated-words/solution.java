// ──────────────────────────────────────────────────
// Problem  : 472. Concatenated Words
// Difficulty: Hard
// Tags     : Array, String, Dynamic Programming, Depth-First Search, Trie, Sorting
// Link     : https://leetcode.com/problems/concatenated-words/
// Runtime  : 69 ms (beats 44%)
// Memory   : 49624000 (beats 98%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        // Sort words by length so shorter words are added to the dictionary first
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        Set<String> wordSet = new HashSet<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            if (canForm(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }

        return result;
    }

    private boolean canForm(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) {
            return false;
        }
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}