// ──────────────────────────────────────────────────
// Problem  : 479. Largest Palindrome Product
// Difficulty: Hard
// Tags     : Math, Enumeration
// Link     : https://leetcode.com/problems/largest-palindrome-product/
// Runtime  : 0 ms (beats 0%)
// Memory   : 40772000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        int upper = (int) Math.pow(10, n) - 1;
        int lower = (int) Math.pow(10, n - 1);

        for (int left = upper; left >= lower; left--) {
            long palindrome = left;
            long x = left;

            while (x > 0) {
                palindrome = palindrome * 10 + x % 10;
                x /= 10;
            }

            for (long factor = upper; factor * factor >= palindrome; factor--) {
                if (palindrome % factor == 0) {
                    long other = palindrome / factor;

                    if (other >= lower && other <= upper) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }

        return 0;
    }
}
