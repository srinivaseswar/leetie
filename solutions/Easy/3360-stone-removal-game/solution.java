// ──────────────────────────────────────────────────
// Problem  : 3360. Stone Removal Game
// Difficulty: Easy
// Tags     : Math, Simulation
// Link     : https://leetcode.com/problems/stone-removal-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41368000 (beats 93%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean aliceTurn = true;

        while (n >= remove) {
            n -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }

        // The player who cannot make a move loses, so the previous player wins.
        return !aliceTurn;
    }
}