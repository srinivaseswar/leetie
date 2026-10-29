// ──────────────────────────────────────────────────
// Problem  : 475. Heaters
// Difficulty: Medium
// Tags     : Array, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/heaters/
// Runtime  : 19 ms (beats 70%)
// Memory   : 47472000 (beats 88%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {
            int left = 0;
            int right = heaters.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            int rightDist = left < heaters.length
                    ? heaters[left] - house
                    : Integer.MAX_VALUE;

            int leftDist = right >= 0
                    ? house - heaters[right]
                    : Integer.MAX_VALUE;

            int nearest = Math.min(leftDist, rightDist);
            radius = Math.max(radius, nearest);
        }

        return radius;
    }
}
