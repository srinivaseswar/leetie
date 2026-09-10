// ──────────────────────────────────────────────────
// Problem  : 242. Valid Anagram
// Difficulty: Easy
// Tags     : Hash Table, String, Sorting
// Link     : https://leetcode.com/problems/valid-anagram/
// Runtime  : 5 ms (beats 63%)
// Memory   : 44384000 (beats 74%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}