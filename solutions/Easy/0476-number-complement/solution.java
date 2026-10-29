// ──────────────────────────────────────────────────
// Problem  : 476. Number Complement
// Difficulty: Easy
// Tags     : Bit Manipulation
// Link     : https://leetcode.com/problems/number-complement/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41208000 (beats 99%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int findComplement(int num) {
        int mask = 1;

        while (mask < num) {
            mask = (mask << 1) | 1;
        }

        return num ^ mask;
    }
}
