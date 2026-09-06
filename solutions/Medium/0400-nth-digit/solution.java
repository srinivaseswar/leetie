// ──────────────────────────────────────────────────
// Problem  : 400. Nth Digit
// Difficulty: Medium
// Tags     : Math, Binary Search
// Link     : https://leetcode.com/problems/nth-digit/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42316000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        // Step 1: Find the length of the number containing the nth digit
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the actual number
        start += (n - 1) / len;

        // Step 3: Extract the specific digit from the number
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}