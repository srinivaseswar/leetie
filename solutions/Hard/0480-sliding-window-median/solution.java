// ──────────────────────────────────────────────────
// Problem  : 480. Sliding Window Median
// Difficulty: Hard
// Tags     : Array, Hash Table, Sliding Window, Heap (Priority Queue), Treap
// Link     : https://leetcode.com/problems/sliding-window-median/
// Runtime  : 132 ms (beats 13%)
// Memory   : 66164000 (beats 58%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    private TreeMap<Integer, Integer> small = new TreeMap<>();
    private TreeMap<Integer, Integer> large = new TreeMap<>();

    private int smallSize = 0;
    private int largeSize = 0;

    private void add(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int num) {
        int count = map.get(num);

        if (count == 1) {
            map.remove(num);
        } else {
            map.put(num, count - 1);
        }
    }

    private void rebalance() {
        while (smallSize > largeSize + 1) {
            int num = small.lastKey();
            remove(small, num);
            smallSize--;
            add(large, num);
            largeSize++;
        }

        while (smallSize < largeSize) {
            int num = large.firstKey();
            remove(large, num);
            largeSize--;
            add(small, num);
            smallSize++;
        }
    }

    private void insert(int num) {
        if (small.isEmpty() || num <= small.lastKey()) {
            add(small, num);
            smallSize++;
        } else {
            add(large, num);
            largeSize++;
        }

        rebalance();
    }

    private void erase(int num) {
        if (small.containsKey(num)) {
            remove(small, num);
            smallSize--;
        } else {
            remove(large, num);
            largeSize--;
        }

        rebalance();
    }

    private double getMedian() {
        if (smallSize > largeSize) {
            return small.lastKey();
        }

        return ((long) small.lastKey() + large.firstKey()) / 2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        small.clear();
        large.clear();
        smallSize = 0;
        largeSize = 0;

        double[] ans = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            insert(nums[i]);
        }

        ans[0] = getMedian();

        for (int i = k; i < nums.length; i++) {
            erase(nums[i - k]);
            insert(nums[i]);
            ans[i - k + 1] = getMedian();
        }

        return ans;
    }
}
