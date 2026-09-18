// ──────────────────────────────────────────────────
// Problem  : 1520. Maximum Number of Non-Overlapping Substrings
// Difficulty: Hard
// Tags     : Hash Table, String, Greedy, Sorting
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
// Runtime  : 7 ms (beats 100%)
// Memory   : 47804000 (beats 88%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans = new ArrayList<>();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Find first and last position of each character
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Create valid intervals
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1)
                continue;

            int l = first[c];
            int r = last[c];
            boolean valid = true;

            for (int i = l; i <= r; i++) {
                int x = s.charAt(i) - 'a';

                // Character occurs before l
                if (first[x] < l) {
                    valid = false;
                    break;
                }

                // Expand interval
                r = Math.max(r, last[x]);
            }

            if (valid) {
                intervals.add(new int[]{l, r});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> a[1] - b[1]);

        int end = -1;

        // Greedy selection
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                ans.add(s.substring(interval[0], interval[1] + 1));
                end = interval[1];
            }
        }

        return ans;
    }
}