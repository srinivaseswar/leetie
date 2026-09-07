// ──────────────────────────────────────────────────
// Problem  : 509. Fibonacci Number
// Difficulty: Easy
// Tags     : Math, Dynamic Programming, Recursion, Memoization
// Link     : https://leetcode.com/problems/fibonacci-number/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41804000 (beats 85%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}