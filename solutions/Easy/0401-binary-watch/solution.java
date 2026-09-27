// ──────────────────────────────────────────────────
// Problem  : 401. Binary Watch
// Difficulty: Easy
// Tags     : Backtracking, Bit Manipulation
// Link     : https://leetcode.com/problems/binary-watch/
// Runtime  : 7 ms (beats 53%)
// Memory   : 44192000 (beats 62%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        // Iterate over all possible hours and minutes
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                // Check if total LEDs on equals turnedOn
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        
        return result;
    }
}