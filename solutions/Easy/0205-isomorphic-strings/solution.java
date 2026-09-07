// ──────────────────────────────────────────────────
// Problem  : 205. Isomorphic Strings
// Difficulty: Easy
// Tags     : Hash Table, String
// Link     : https://leetcode.com/problems/isomorphic-strings/
// Runtime  : 6 ms (beats 89%)
// Memory   : 43812000 (beats 58%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }

        return true;
    }
}