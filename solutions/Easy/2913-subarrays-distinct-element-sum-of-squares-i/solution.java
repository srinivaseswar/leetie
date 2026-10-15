// ──────────────────────────────────────────────────
// Problem  : 2913. Subarrays Distinct Element Sum of Squares I
// Difficulty: Easy
// Tags     : Array, Hash Table, Binary Indexed Tree, Segment Tree
// Link     : https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
// Runtime  : 10 ms (beats 27%)
// Memory   : 46552000 (beats 79%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();
        
        // Generate all possible subarrays
        for (int i = 0; i < n; i++) {
            Set<Integer> distinctSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                // Add elements to the set for the current subarray nums[i..j]
                distinctSet.add(nums.get(j));
                
                // Get distinct count
                int distinctCount = distinctSet.size();
                
                // Add the square of the distinct count to the total sum
                totalSum += distinctCount * distinctCount;
            }
        }
        
        return totalSum;
    }
}