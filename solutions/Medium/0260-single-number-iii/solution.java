// ──────────────────────────────────────────────────
// Problem  : 260. Single Number III
// Difficulty: Medium
// Tags     : Array, Bit Manipulation
// Link     : https://leetcode.com/problems/single-number-iii/
// Runtime  : 1 ms (beats 100%)
// Memory   : 48164000 (beats 22%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

       
        long diff = xor & -(long) xor;

        
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num; 
            } else {
                result[1] ^= num; 
            }
        }

        return result;
    }
}