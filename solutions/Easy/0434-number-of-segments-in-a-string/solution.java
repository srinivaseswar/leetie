// ──────────────────────────────────────────────────
// Problem  : 434. Number of Segments in a String
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/number-of-segments-in-a-string/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42636000 (beats 50%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check if current character is the start of a segment
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}