// ──────────────────────────────────────────────────
// Problem  : 492. Construct the Rectangle
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/construct-the-rectangle/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41472000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);

        while (area % w != 0) {
            w--;
        }

        int l = area / w;

        return new int[]{l, w};
    }
}