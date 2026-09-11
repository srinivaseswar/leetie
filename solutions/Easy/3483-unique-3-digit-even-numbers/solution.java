// ──────────────────────────────────────────────────
// Problem  : 3483. Unique 3-Digit Even Numbers
// Difficulty: Easy
// Tags     : Array, Hash Table, Recursion, Enumeration
// Link     : https://leetcode.com/problems/unique-3-digit-even-numbers/
// Runtime  : 9 ms (beats 26%)
// Memory   : 46916000 (beats 12%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalNumbers(int[] digits) {
        // Count frequencies of each digit available
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        // Check every 3-digit even number
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            int[] required = new int[10];
            required[d1]++;
            required[d2]++;
            required[d3]++;

            // Verify if available frequencies satisfy the requirement
            if (required[d1] <= freq[d1] && 
                required[d2] <= freq[d2] && 
                required[d3] <= freq[d3]) {
                count++;
            }
        }

        return count;
    }
}