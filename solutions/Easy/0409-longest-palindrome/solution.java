// ──────────────────────────────────────────────────
// Problem  : 409. Longest Palindrome
// Difficulty: Easy
// Tags     : Hash Table, String, Greedy
// Link     : https://leetcode.com/problems/longest-palindrome/
// Runtime  : 1 ms (beats 100%)
// Memory   : 42892000 (beats 92%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128]; // Tracks frequencies of ASCII characters
        
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        for (int count : counts) {
            length += (count / 2) * 2; // Add the largest even portion
            if (count % 2 == 1) {
                hasOdd = true; // Flag if there is an odd count character available for the center
            }
        }
        
        return hasOdd ? length + 1 : length;
    }
}