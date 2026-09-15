// ──────────────────────────────────────────────────
// Problem  : 2472. Maximum Number of Non-overlapping Palindrome Substrings
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
// Runtime  : 5 ms (beats 64%)
// Memory   : 42648000 (beats 95%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int lastEnd = -1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int minEnd = Integer.MAX_VALUE;

            // 1. Check odd-length palindromes centered at i
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    if (l > lastEnd) {
                        minEnd = Math.min(minEnd, r);
                    }
                    break; // Shortest valid palindrome ending earliest
                }
                l--;
                r++;
            }

            // 2. Check even-length palindromes centered at (i, i+1)
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    if (l > lastEnd) {
                        minEnd = Math.min(minEnd, r);
                    }
                    break; // Shortest valid palindrome ending earliest
                }
                l--;
                r++;
            }

            // If a valid palindrome was found starting after lastEnd, accept the earliest one
            if (minEnd != Integer.MAX_VALUE) {
                count++;
                lastEnd = minEnd;
            }
        }

        return count;
    }
}