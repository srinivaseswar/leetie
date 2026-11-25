// ──────────────────────────────────────────────────
// Problem  : 3934. Smallest Unique Subarray
// Difficulty: Hard
// Tags     : Array, Hash Table, Binary Search, Rolling Hash, Suffix Array, Hash Function
// Link     : https://leetcode.com/problems/smallest-unique-subarray/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42852000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] last = new int[100001];

        int ans = n;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            int distance = i - last[x] + 1;

            ans = Math.min(ans, distance);

            last[x] = i + 1;
        }

        return ans;
    }
}
