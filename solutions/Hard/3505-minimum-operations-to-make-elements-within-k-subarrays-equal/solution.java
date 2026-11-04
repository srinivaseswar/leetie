// ──────────────────────────────────────────────────
// Problem  : 3505. Minimum Operations to Make Elements Within K Subarrays Equal
// Difficulty: Hard
// Tags     : Array, Hash Table, Math, Dynamic Programming, Sliding Window, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41760000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        
        // Step 1: Precalculate cost for each window of size x
        long[] cost = new long[n - x + 1];
        MedianTracker tracker = new MedianTracker();
        
        for (int i = 0; i < x; i++) {
            tracker.add(nums[i]);
        }
        cost[0] = tracker.getCost();
        
        for (int i = x; i < n; i++) {
            tracker.remove(nums[i - x]);
            tracker.add(nums[i]);
            cost[i - x + 1] = tracker.getCost();
        }
        
        // Step 2: Dynamic programming for k non-overlapping subarrays
        long[][] dp = new long[k + 1][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        
        dp[0][0] = 0;
        for (int j = 1; j <= k; j++) {
            long minPrev = dp[j - 1][0];
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x) {
                    minPrev = Math.min(minPrev, dp[j - 1][i - x]);
                    dp[j][i] = Math.min(dp[j][i], minPrev + cost[i - x]);
                }
            }
        }
        
        return dp[k][n];
    }
    
    private static class MedianTracker {
        private final TreeMap<Integer, Integer> left = new TreeMap<>();
        private final TreeMap<Integer, Integer> right = new TreeMap<>();
        private int leftSize = 0, rightSize = 0;
        private long leftSum = 0, rightSum = 0;

        public void add(int num) {
            if (left.isEmpty() || num <= left.lastKey()) {
                left.put(num, left.getOrDefault(num, 0) + 1);
                leftSum += num;
                leftSize++;
            } else {
                right.put(num, right.getOrDefault(num, 0) + 1);
                rightSum += num;
                rightSize++;
            }
            balance();
        }

        public void remove(int num) {
            if (left.containsKey(num)) {
                leftSum -= num;
                leftSize--;
                decrement(left, num);
            } else if (right.containsKey(num)) {
                rightSum -= num;
                rightSize--;
                decrement(right, num);
            }
            balance();
        }

        private void decrement(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);
            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        private void balance() {
            while (leftSize < rightSize) {
                Map.Entry<Integer, Integer> entry = right.firstEntry();
                int val = entry.getKey();
                int count = entry.getValue();
                right.remove(val);
                rightSum -= (long) val * count;
                rightSize -= count;

                left.put(val, left.getOrDefault(val, 0) + count);
                leftSum += (long) val * count;
                leftSize += count;
            }
            while (leftSize > rightSize + 1) {
                Map.Entry<Integer, Integer> entry = left.lastEntry();
                int val = entry.getKey();
                int count = entry.getValue();
                left.remove(val);
                leftSum -= (long) val * count;
                leftSize -= count;

                right.put(val, right.getOrDefault(val, 0) + count);
                rightSum += (long) val * count;
                rightSize += count;
            }
        }

        public long getCost() {
            if (left.isEmpty()) return 0;
            int median = left.lastKey();
            long leftCost = (long) median * leftSize - leftSum;
            long rightCost = rightSum - (long) median * rightSize;
            return leftCost + rightCost;
        }
    }
}