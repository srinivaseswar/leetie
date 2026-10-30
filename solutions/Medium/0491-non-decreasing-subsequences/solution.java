// ──────────────────────────────────────────────────
// Problem  : 491. Non-decreasing Subsequences
// Difficulty: Medium
// Tags     : Array, Hash Table, Backtracking, Bit Manipulation
// Link     : https://leetcode.com/problems/non-decreasing-subsequences/
// Runtime  : 12 ms (beats 36%)
// Memory   : 53640000 (beats 11%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }
    
    private void backtrack(int[] nums, int index, List<Integer> current, Set<List<Integer>> result) {
        // If we have at least 2 elements, it's a valid non-decreasing subsequence
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }
        
        // Local set at this recursion level to prevent duplicate branches from identical numbers
        Set<Integer> usedAtThisLevel = new HashSet<>();
        
        for (int i = index; i < nums.length; i++) {
            // Skip if we already used this exact number at this level
            if (usedAtThisLevel.contains(nums[i])) {
                continue;
            }
            
            // Maintain non-decreasing order constraint
            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                usedAtThisLevel.add(nums[i]);
                current.add(nums[i]);
                backtrack(nums, i + 1, current, result);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }
}