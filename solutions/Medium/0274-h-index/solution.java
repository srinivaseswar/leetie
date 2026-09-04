// ──────────────────────────────────────────────────
// Problem  : 274. H-Index
// Difficulty: Medium
// Tags     : Array, Sorting, Counting Sort
// Link     : https://leetcode.com/problems/h-index/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42112000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        
        // Populate bucket frequencies
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }
        
        int totalPapers = 0;
        // Count from highest possible h-index downwards
        for (int h = n; h >= 0; h--) {
            totalPapers += count[h];
            if (totalPapers >= h) {
                return h;
            }
        }
        
        return 0;
    }
}