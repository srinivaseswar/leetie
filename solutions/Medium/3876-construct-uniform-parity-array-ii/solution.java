// ──────────────────────────────────────────────────
// Problem  : 3876. Construct Uniform Parity Array II
// Difficulty: Medium
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/construct-uniform-parity-array-ii/
// Runtime  : 5 ms (beats 83%)
// Memory   : 121732000 (beats 44%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int num : nums1) {
            if (num < minVal) {
                minVal = num;
            }
            if (num % 2 != 0) {
                hasOdd = true;
            }
        }

        return (minVal % 2 != 0) || !hasOdd;
    }
}