// ──────────────────────────────────────────────────
// Problem  : 316. Remove Duplicate Letters
// Difficulty: Medium
// Tags     : String, Stack, Greedy, Monotonic Stack
// Link     : https://leetcode.com/problems/remove-duplicate-letters/
// Runtime  : 2 ms (beats 80%)
// Memory   : 43132000 (beats 97%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastCount = new int[26];
        boolean[] visited = new boolean[26];
        
       
        for (char c : s.toCharArray()) {
            lastCount[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            
            
            lastCount[idx]--;
            
            
            if (visited[idx]) {
                continue;
            }
            

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && lastCount[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
            sb.append(c);
            visited[idx] = true;
        }
        
        return sb.toString();
    }
}