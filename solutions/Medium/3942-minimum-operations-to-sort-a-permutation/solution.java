// ──────────────────────────────────────────────────
// Problem  : 3942. Minimum Operations to Sort a Permutation
// Difficulty: Medium
// Tags     : Array
// Link     : https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
// Runtime  : 5 ms (beats 53%)
// Memory   : 94152000 (beats 97%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        // Helper to check if array is a rotation of a target pattern
        int incShift = -1;
        int decShift = -1;

        boolean isInc = true;
        boolean isDec = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) isInc = false;
            if (nums[i] != n - 1 - i) isDec = false;
        }

        // Check cyclic increasing
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        boolean cyclicInc = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zeroIdx + i) % n] != i) {
                cyclicInc = false;
                break;
            }
        }

        if (cyclicInc) {
            // Option 1: Just rotate left zeroIdx times
            int ans = zeroIdx;
            // Option 2: Reverse, then rotate, then reverse (costs: 1 + (n - zeroIdx) % n + 1)
            int alt = 2 + (n - zeroIdx) % n;
            return Math.min(ans, alt);
        }

        // Check cyclic decreasing
        int nMinusOneIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == n - 1) {
                nMinusOneIdx = i;
                break;
            }
        }

        boolean cyclicDec = true;
        for (int i = 0; i < n; i++) {
            if (nums[(nMinusOneIdx + i) % n] != n - 1 - i) {
                cyclicDec = false;
                break;
            }
        }

        if (cyclicDec) {
            // Option 1: Reverse first, then rotate
            int ans1 = 1 + (n - nMinusOneIdx) % n;
            // Option 2: Rotate first, then reverse
            int ans2 = nMinusOneIdx + 1;
            return Math.min(ans1, ans2);
        }

        return -1;
    }
}