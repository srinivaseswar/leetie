// ──────────────────────────────────────────────────
// Problem  : 1520. Maximum Number of Non-Overlapping Substrings
// Difficulty: Hard
// Tags     : Hash Table, String, Greedy, Sorting
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
// Runtime  : 8 ms (beats 96%)
// Memory   : 48032000 (beats 61%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // Step 1: Record first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        // Step 2: Find all valid candidate substrings [l, r]
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int l = first[i];
            int r = last[i];
            boolean valid = true;

            for (int j = l; j <= r; j++) {
                int c = s.charAt(j) - 'a';
                if (first[c] < l) { 
                    // Character appears before 'l', invalid candidate starting at 'l'
                    valid = false; 
                    break; 
                }
                r = Math.max(r, last[c]);
            }

            if (valid) {
                intervals.add(new int[]{l, r});
            }
        }

        // Step 3: Sort intervals by end index (greedy choice)
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        // Step 4: Select non-overlapping intervals
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (l > prevEnd) {
                result.add(s.substring(l, r + 1));
                prevEnd = r;
            }
        }

        return result;
    }
}