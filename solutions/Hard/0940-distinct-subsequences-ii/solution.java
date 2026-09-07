// ──────────────────────────────────────────────────
// Problem  : 940. Distinct Subsequences II
// Difficulty: Hard
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/distinct-subsequences-ii/
// Runtime  : 3 ms (beats 89%)
// Memory   : 43260000 (beats 70%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int[] last = new int[26];
        int total = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            // Calculate new distinct subsequences ending at character c
            int newAdded = (total + 1 - last[idx]) % MOD;
            if (newAdded < 0) {
                newAdded += MOD;
            }

            total = (total + newAdded) % MOD;
            last[idx] = (last[idx] + newAdded) % MOD;
        }

        return total;
    }
}