// ──────────────────────────────────────────────────
// Problem  : 423. Reconstruct Original Digits from English
// Difficulty: Medium
// Tags     : Hash Table, Math, String
// Link     : https://leetcode.com/problems/reconstruct-original-digits-from-english/
// Runtime  : 5 ms (beats 67%)
// Memory   : 46188000 (beats 87%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String originalDigits(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
        int[] digitCounts = new int[10];
        
        // Unique character matches
        digitCounts[0] = charCounts['z' - 'a'];
        digitCounts[2] = charCounts['w' - 'a'];
        digitCounts[4] = charCounts['u' - 'a'];
        digitCounts[6] = charCounts['x' - 'a'];
        digitCounts[8] = charCounts['g' - 'a'];
        
        // Derived matches
        digitCounts[3] = charCounts['h' - 'a'] - digitCounts[8];
        digitCounts[5] = charCounts['f' - 'a'] - digitCounts[4];
        digitCounts[7] = charCounts['s' - 'a'] - digitCounts[6];
        digitCounts[1] = charCounts['o' - 'a'] - digitCounts[0] - digitCounts[2] - digitCounts[4];
        digitCounts[9] = charCounts['i' - 'a'] - digitCounts[5] - digitCounts[6] - digitCounts[8];
        
        // Build the result string in ascending order
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < digitCounts[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}