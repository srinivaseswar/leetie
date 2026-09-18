// ──────────────────────────────────────────────────
// Problem  : 1520. Maximum Number of Non-Overlapping Substrings
// Difficulty: Hard
// Tags     : Hash Table, String, Greedy, Sorting
// Link     : https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
// Runtime  : 8 ms (beats 96%)
// Memory   : 47968000 (beats 78%)
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

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        List<int[]> validIntervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int l = first[i];
            int r = last[i];
            boolean isValid = true;

            for (int j = l; j <= r; j++) {
                int c = s.charAt(j) - 'a';
                if (first[c] < l) {
                    isValid = false; // Expanded outside our current left boundary
                    break;
                }
                r = Math.max(r, last[c]); // Expand right boundary to include all occurrences of char c
            }

            if (isValid) {
                validIntervals.add(new int[]{l, r});
            }
        }

        // Sort intervals by their end points (Greedy Activity Selection)
        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> res = new ArrayList<>();
        int lastEnd = -1;

        for (int[] interval : validIntervals) {
            int l = interval[0];
            int r = interval[1];

            if (l > lastEnd) {
                res.add(s.substring(l, r + 1));
                lastEnd = r;
            }
        }

        return res;
    }
}