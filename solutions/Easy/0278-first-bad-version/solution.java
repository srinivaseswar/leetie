// ──────────────────────────────────────────────────
// Problem  : 278. First Bad Version
// Difficulty: Easy
// Tags     : Binary Search, Interactive
// Link     : https://leetcode.com/problems/first-bad-version/
// Runtime  : 13 ms (beats 100%)
// Memory   : 42028000 (beats 55%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            // Avoid potential integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // mid could be the first bad version, search left half
                right = mid;
            } else {
                // mid is good, so first bad version must be after mid
                left = mid + 1;
            }
        }
        
        return left;
    }
}