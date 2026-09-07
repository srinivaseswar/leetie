// ──────────────────────────────────────────────────
// Problem  : 1320. Minimum Distance to Type a Word Using Two Fingers
// Difficulty: Hard
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42584000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int minimumDistance(String word) {
        int[] dp = new int[27]; // dp[i]: min distance where other finger is at character i (26 = unused)
        Arrays.fill(dp, 0);

        for (int i = 0; i < word.length() - 1; i++) {
            int cur = word.charAt(i) - 'A';
            int next = word.charAt(i + 1) - 'A';
            int d = dist(cur, next);

            int[] nextDp = new int[27];
            Arrays.fill(nextDp, Integer.MAX_VALUE / 2);

            for (int other = 0; other <= 26; other++) {
                if (dp[other] == Integer.MAX_VALUE / 2) continue;

                // Option 1: Move the same finger (from cur to next)
                nextDp[other] = Math.min(nextDp[other], dp[other] + d);

                // Option 2: Move the other finger (from other to next)
                nextDp[cur] = Math.min(nextDp[cur], dp[other] + dist(other, next));
            }

            dp = nextDp;
        }

        int minDist = Integer.MAX_VALUE;
        for (int val : dp) {
            minDist = Math.min(minDist, val);
        }

        return minDist;
    }

    private int dist(int a, int b) {
        if (a == 26 || b == 26) return 0;
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}