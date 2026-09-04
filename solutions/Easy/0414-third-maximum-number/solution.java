// ──────────────────────────────────────────────────
// Problem  : 414. Third Maximum Number
// Difficulty: Easy
// Tags     : Array, Sorting
// Link     : https://leetcode.com/problems/third-maximum-number/
// Runtime  : 4 ms (beats 44%)
// Memory   : 45156000 (beats 32%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        
        for (Integer num : nums) {
            // Skip duplicates
            if (num.equals(first) || num.equals(second) || num.equals(third)) {
                continue;
            }
            
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }
        
        return third != null ? third : first;
    }
}