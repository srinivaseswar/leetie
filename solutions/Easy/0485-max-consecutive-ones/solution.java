// ──────────────────────────────────────────────────
// Problem  : 485. Max Consecutive Ones
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/max-consecutive-ones/
// Runtime  : 2 ms (beats 98%)
// Memory   : 52032000 (beats 89%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }
        
        return maxCount;
    }
}