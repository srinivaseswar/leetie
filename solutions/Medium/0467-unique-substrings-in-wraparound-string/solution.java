// ──────────────────────────────────────────────────
// Problem  : 467. Unique Substrings in Wraparound String
// Difficulty: Medium
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/unique-substrings-in-wraparound-string/
// Runtime  : 9 ms (beats 87%)
// Memory   : 44320000 (beats 88%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findSubstringInWraproundString(String s) {
        // count[i] stores the maximum length of valid contiguous substring ending with char (i + 'a')
        int[] count = new int[26];
        
        int maxLengthCur = 0; // current continuous substring length
        
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            
            // Check if it continues the wraparound sequence from the previous character
            if (i > 0 && (currChar - s.charAt(i - 1) == 1 || (s.charAt(i - 1) == 'z' && currChar == 'a'))) {
                maxLengthCur++;
            } else {
                maxLengthCur = 1;
            }
            
            int charIndex = currChar - 'a';
            count[charIndex] = Math.max(count[charIndex], maxLengthCur);
        }
        
        // Sum up all unique substrings
        int totalUniqueSubstrings = 0;
        for (int c : count) {
            totalUniqueSubstrings += c;
        }
        
        return totalUniqueSubstrings;
    }
}