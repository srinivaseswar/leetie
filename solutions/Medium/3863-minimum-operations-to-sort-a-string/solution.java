// ──────────────────────────────────────────────────
// Problem  : 3863. Minimum Operations to Sort a String
// Difficulty: Medium
// Tags     : String
// Link     : https://leetcode.com/problems/minimum-operations-to-sort-a-string/
// Runtime  : 9 ms (beats 97%)
// Memory   : 47220000 (beats 97%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        
        // Check if already sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        // If length is 2 and not sorted, we can't sort proper substrings to fix it
        if (n == 2) return -1;
        
        // Find min and max characters
        char minChar = chars[0], maxChar = chars[0];
        for (char c : chars) {
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        // Check if 1 operation is enough:
        // Min char at index 0 (and not whole string) or Max char at index n-1 (and not whole string)
        if (chars[0] == minChar || chars[n - 1] == maxChar) {
            return 1;
        }
        
        // Check if 3 operations are needed:
        // Max char is exclusively at index 0 and Min char is exclusively at index n-1
        boolean onlyMaxAtStart = (chars[0] == maxChar);
        for (int i = 1; i < n; i++) {
            if (chars[i] == maxChar) {
                onlyMaxAtStart = false;
                break;
            }
        }
        
        boolean onlyMinAtEnd = (chars[n - 1] == minChar);
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == minChar) {
                onlyMinAtEnd = false;
                break;
            }
        }
        
        if (onlyMaxAtStart && onlyMinAtEnd) {
            return 3;
        }
        
        // Otherwise, 2 operations suffice
        return 2;
    }
}