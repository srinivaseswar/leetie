// ──────────────────────────────────────────────────
// Problem  : 443. String Compression
// Difficulty: Medium
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/string-compression/
// Runtime  : 1 ms (beats 100%)
// Memory   : 44692000 (beats 98%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;
        int n = chars.length;
        
        while (read < n) {
            char currentChar = chars[read];
            int count = 0;
            
            // Count consecutive repeating characters
            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }
            
            // Write the character
            chars[write++] = currentChar;
            
            // If count is greater than 1, write its digits
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (int i = 0; i < countStr.length(); i++) {
                    chars[write++] = countStr.charAt(i);
                }
            }
        }
        
        return write;
    }
}