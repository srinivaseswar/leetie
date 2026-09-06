// ──────────────────────────────────────────────────
// Problem  : 372. Super Pow
// Difficulty: Medium
// Tags     : Math, Divide and Conquer, Euler's Totient Function, Euler's Theorem
// Link     : https://leetcode.com/problems/super-pow/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41756000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        int result = 1;
        
        for (int i = b.length - 1; i >= 0; i--) {
            result = (result * power(a, b[i])) % MOD;
            a = power(a, 10);
        }
        
        return result;
    }

    private int power(int base, int exp) {
        int res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}