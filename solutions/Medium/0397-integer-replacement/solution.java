// ──────────────────────────────────────────────────
// Problem  : 397. Integer Replacement
// Difficulty: Medium
// Tags     : Dynamic Programming, Greedy, Bit Manipulation, Memoization
// Link     : https://leetcode.com/problems/integer-replacement/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41708000 (beats 84%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int count = 0;
        
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                // If num is 3 or second-to-last bit is 0 (e.g., ends in ...01 in binary), decrement
                if (num == 3 || (num & 3) == 1) {
                    num -= 1;
                } else {
                    num += 1;
                }
            }
            count++;
        }
        
        return count;
    }
}