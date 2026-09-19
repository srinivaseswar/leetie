// ──────────────────────────────────────────────────
// Problem  : 1401. Circle and Rectangle Overlapping
// Difficulty: Medium
// Tags     : Math, Geometry
// Link     : https://leetcode.com/problems/circle-and-rectangle-overlapping/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42116000 (beats 61%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
       
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        
        int dx = nearestX - xCenter;
        int dy = nearestY - yCenter;
        
        return (dx * dx + dy * dy) <= (radius * radius);
    }
}