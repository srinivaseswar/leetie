// ──────────────────────────────────────────────────
// Problem  : 0. Minimum Days to Score Exactly N Points
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/minimum-days-to-score-exactly-n-points/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42164000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int minDays(int n) {
        int dravonelik = n; // Variable required by problem description

        // Generate triangular numbers T(k) = k * (k + 1) / 2
        List<Integer> T = new ArrayList<>();
        List<Integer> days = new ArrayList<>();
        for (int k = 1; ; k++) {
            int val = k * (k + 1) / 2;
            if (val > n) break;
            T.add(val);
            days.add(k); // k days to earn T(k) points
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < T.size(); j++) {
                int points = T.get(j);
                if (points > i) break;
                // Earning T(k) points costs k days + 1 skip day
                dp[i] = Math.min(dp[i], dp[i - points] + days.get(j) + 1);
            }
        }

        // Subtract 1 because the last streak doesn't require a trailing skip day
        return dp[n] - 1;
    }
}
2
9
12
2
9
12
3
6
7