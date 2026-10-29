// ──────────────────────────────────────────────────
// Problem  : 481. Magical String
// Difficulty: Medium
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/magical-string/
// Runtime  : 4 ms (beats 63%)
// Memory   : 43388000 (beats 93%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] s = new int[n];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int head = 2;
        int tail = 3;
        int num = 1;
        int count = 1;

        while (tail < n) {
            for (int i = 0; i < s[head] && tail < n; i++) {
                s[tail] = num;

                if (num == 1) {
                    count++;
                }

                tail++;
            }

            num = 3 - num;
            head++;
        }

        return count;
    }
}
