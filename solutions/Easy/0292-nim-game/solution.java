// ──────────────────────────────────────────────────
// Problem  : 292. Nim Game
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/nim-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42296000 (beats 17%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}