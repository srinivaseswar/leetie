// ──────────────────────────────────────────────────
// Problem  : 3934. Smallest Unique Subarray
// Difficulty: Hard
// Tags     : Array, Hash Table, Binary Search, Rolling Hash, Suffix Array, Hash Function
// Link     : https://leetcode.com/problems/smallest-unique-subarray/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41908000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    static final long MOD1 = 1000000007L;
    static final long MOD2 = 1000000009L;
    static final long BASE = 911382323L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long[] h1 = new long[n + 1];
        long[] h2 = new long[n + 1];
        long[] p1 = new long[n + 1];
        long[] p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * BASE + nums[i]) % MOD1;
            h2[i + 1] = (h2[i] * BASE + nums[i]) % MOD2;

            p1[i + 1] = p1[i] * BASE % MOD1;
            p2[i + 1] = p2[i] * BASE % MOD2;
        }

        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (hasUnique(mid, n, h1, h2, p1, p2)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean hasUnique(int len, int n,
            long[] h1, long[] h2,
            long[] p1, long[] p2) {

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {
            int j = i + len;

            long a = (h1[j] - h1[i] * p1[len] % MOD1 + MOD1) % MOD1;
            long b = (h2[j] - h2[i] * p2[len] % MOD2 + MOD2) % MOD2;

            long key = (a << 32) | b;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
