// ──────────────────────────────────────────────────
// Problem  : 313. Super Ugly Number
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming
// Link     : https://leetcode.com/problems/super-ugly-number/
// Runtime  : 44 ms (beats 48%)
// Memory   : 44224000 (beats 51%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly = new long[n];
        ugly[0] = 1;
        
        int k = primes.length;
        int[] indices = new int[k]; 
        
        for (int i = 1; i < n; i++) {
            long nextUgly = Long.MAX_VALUE;
            
            
            for (int j = 0; j < k; j++) {
                nextUgly = Math.min(nextUgly, (long) primes[j] * ugly[indices[j]]);
            }
            
            ugly[i] = nextUgly;
            
           
            for (int j = 0; j < k; j++) {
                if (nextUgly == (long) primes[j] * ugly[indices[j]]) {
                    indices[j]++;
                }
            }
        }
        
        return (int) ugly[n - 1];
    }
}