// ──────────────────────────────────────────────────
// Problem  : 258. Add Digits
// Difficulty: Easy
// Tags     : Math, Simulation, Number Theory
// Link     : https://leetcode.com/problems/add-digits/
// Runtime  : 1 ms (beats 98%)
// Memory   : 42708000 (beats 25%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        if(num % 9 == 0) return 9;
        return num % 9;


        
    }
}