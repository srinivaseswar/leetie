// ──────────────────────────────────────────────────
// Problem  : 387. First Unique Character in a String
// Difficulty: Easy
// Tags     : Hash Table, String, Queue, Counting
// Link     : https://leetcode.com/problems/first-unique-character-in-a-string/
// Runtime  : 6 ms (beats 85%)
// Memory   : 46956000 (beats 58%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int firstUniqChar(String s) {
        int[] counts = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}