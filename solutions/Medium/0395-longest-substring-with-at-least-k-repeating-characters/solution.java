// ──────────────────────────────────────────────────
// Problem  : 395. Longest Substring with At Least K Repeating Characters
// Difficulty: Medium
// Tags     : Hash Table, String, Divide and Conquer, Sliding Window
// Link     : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
// Runtime  : 1 ms (beats 76%)
// Memory   : 42460000 (beats 97%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }
    
    private int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        
        int[] counts = new int[26];
        for (int i = start; i < end; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        for (int i = start; i < end; i++) {
            if (counts[s.charAt(i) - 'a'] < k) {
                int midNext = i + 1;
                
                while (midNext < end && counts[s.charAt(midNext) - 'a'] < k) {
                    midNext++;
                }
                
                int left = helper(s, start, i, k);
                int right = helper(s, midNext, end, k);
                
                return Math.max(left, right);
            }
        }
        
        return end - start; 
    }
}