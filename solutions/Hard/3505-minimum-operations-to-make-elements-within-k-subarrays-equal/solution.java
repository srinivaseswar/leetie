// ──────────────────────────────────────────────────
// Problem  : 3505. Minimum Operations to Make Elements Within K Subarrays Equal
// Difficulty: Hard
// Tags     : Array, Hash Table, Math, Dynamic Programming, Sliding Window, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41256000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        
        // Step 1: Precalculate cost for every subarray of length x
        long[] cost = new long[n - x + 1];
        // Using a sliding window approach with two heaps/multisets to track the median and sums.
        
        // Step 2: Dynamic programming to pick k non-overlapping windows
        // dp[j][i] = min cost using j windows up to index i
        long[][] dp = new long[k + 1][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        
        dp[0][0] = 0;
        for (int j = 1; j <= k; j++) {
            long minPrev = dp[j - 1][0];
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1]; // Option 1: don't end a window at i
                if (i >= x) {
                    dp[j][i] = Math.min(dp[j][i], dp[j - 1][i - x] + cost[i - x]);
                }
            }
        }
        
        return dp[k][n];
    }
}