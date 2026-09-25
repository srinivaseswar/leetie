// ──────────────────────────────────────────────────
// Problem  : 275. H-Index II
// Difficulty: Medium
// Tags     : Array, Binary Search
// Link     : https://leetcode.com/problems/h-index-ii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 50344000 (beats 27%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;
            
            if (citations[mid] == h) {
                return h;
            } else if (citations[mid] < h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return n - left;
    }
}