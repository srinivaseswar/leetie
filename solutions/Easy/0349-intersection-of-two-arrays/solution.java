// ──────────────────────────────────────────────────
// Problem  : 349. Intersection of Two Arrays
// Difficulty: Easy
// Tags     : Array, Hash Table, Two Pointers, Binary Search, Sorting
// Link     : https://leetcode.com/problems/intersection-of-two-arrays/
// Runtime  : 2 ms (beats 97%)
// Memory   : 45176000 (beats 25%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        
        return result;
    }
}