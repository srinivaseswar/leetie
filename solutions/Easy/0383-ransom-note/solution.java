// ──────────────────────────────────────────────────
// Problem  : 383. Ransom Note
// Difficulty: Easy
// Tags     : Hash Table, String, Counting
// Link     : https://leetcode.com/problems/ransom-note/
// Runtime  : 1 ms (beats 100%)
// Memory   : 46224000 (beats 79%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        
        int[] letterCounts = new int[26];
        
        // Count characters in magazine
        for (char c : magazine.toCharArray()) {
            letterCounts[c - 'a']++;
        }
        
        // Check characters required for ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (letterCounts[c - 'a'] == 0) {
                return false; // Not enough instances of character c
            }
            letterCounts[c - 'a']--;
        }
        
        return true;
    }
}