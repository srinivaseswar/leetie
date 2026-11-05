// ──────────────────────────────────────────────────
// Problem  : 1385. Find the Distance Value Between Two Arrays
// Difficulty: Easy
// Tags     : Array, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
// Runtime  : 6 ms (beats 35%)
// Memory   : 46376000 (beats 35%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // Sort arr2 to enable binary search
        Arrays.sort(arr2);
        int distanceCount = 0;
        
        for (int val : arr1) {
            if (isValid(arr2, val, d)) {
                distanceCount++;
            }
        }
        
        return distanceCount;
    }
    
    private boolean isValid(int[] arr2, int target, int d) {
        int left = 0;
        int right = arr2.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If the absolute difference is within d, condition is violated
            if (Math.abs(arr2[mid] - target) <= d) {
                return false;
            }
            
            if (arr2[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return true;
    }
}