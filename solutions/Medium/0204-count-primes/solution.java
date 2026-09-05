// ──────────────────────────────────────────────────
// Problem  : 204. Count Primes
// Difficulty: Medium
// Tags     : Array, Math, Enumeration, Number Theory, Primality Test, Sieve Theory, Prime Number Sieve
// Link     : https://leetcode.com/problems/count-primes/
// Runtime  : 794 ms (beats 7%)
// Memory   : 80116000 (beats 9%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        boolean[] isPrime = new boolean[n];
        // Assume all numbers >= 2 are prime initially
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        
        // Mark multiples starting from i * i
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Count remaining primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        
        return count;
    }
}