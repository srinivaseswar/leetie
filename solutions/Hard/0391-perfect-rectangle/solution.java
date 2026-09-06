// ──────────────────────────────────────────────────
// Problem  : 391. Perfect Rectangle
// Difficulty: Hard
// Tags     : Array, Hash Table, Math, Geometry, Sweep Line
// Link     : https://leetcode.com/problems/perfect-rectangle/
// Runtime  : 43 ms (beats 27%)
// Memory   : 55748000 (beats 66%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        
        long totalArea = 0;
        Set<String> corners = new HashSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];

            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            totalArea += (long) (x2 - x1) * (y2 - y1);

            // Add/remove corner points using symmetric difference
            String[] pts = {
                x1 + "," + y1,
                x1 + "," + y2,
                x2 + "," + y1,
                x2 + "," + y2
            };

            for (String pt : pts) {
                if (!corners.add(pt)) {
                    corners.remove(pt); // Even number of appearances cancel out
                }
            }
        }

        // Verify total bounding area matches area sum
        long expectedArea = (long) (maxX - minX) * (maxY - minY);
        if (totalArea != expectedArea) return false;

        // Verify that exactly 4 outer corners remain
        if (corners.size() != 4 || 
            !corners.contains(minX + "," + minY) || 
            !corners.contains(minX + "," + maxY) || 
            !corners.contains(maxX + "," + minY) || 
            !corners.contains(maxX + "," + maxY)) {
            return false;
        }

        return true;
    }
}