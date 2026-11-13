// ──────────────────────────────────────────────────
// Problem  : 3420. Count Non-Decreasing Subarrays After K Operations
// Difficulty: Hard
// Tags     : Array, Stack, Segment Tree, Queue, Sliding Window, Monotonic Stack, Monotonic Queue
// Link     : https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/
// Runtime  : 26 ms (beats 93%)
// Memory   : 132192000 (beats 46%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    static class Group {
        int value;
        int count;

        Group(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<Group> deque = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;
        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {
            int x = nums[left];
            int count = 1;

            while (!deque.isEmpty() &&
                   deque.peekFirst().value < x) {

                Group g = deque.pollFirst();

                cost += (long) (x - g.value) * g.count;
                count += g.count;
            }

            deque.addFirst(new Group(x, count));

            while (cost > k) {
                Group g = deque.peekLast();

                cost -= (long) g.value - nums[right];

                g.count--;

                if (g.count == 0) {
                    deque.pollLast();
                }

                right--;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}