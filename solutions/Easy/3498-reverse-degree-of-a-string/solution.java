// ──────────────────────────────────────────────────
// Problem  : 3498. Reverse Degree of a String
// Difficulty: Easy
// Tags     : String, Simulation
// Link     : https://leetcode.com/problems/reverse-degree-of-a-string/
// Runtime  : 1 ms (beats 100%)
// Memory   : 43896000 (beats 81%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int reversedAlphabetIndex = 'z' - c + 1; // 'a' -> 26, 'b' -> 25, ..., 'z' -> 1
            int stringIndex = i + 1;                  // 1-indexed position
            total += reversedAlphabetIndex * stringIndex;
        }
        return total;
    }
}