// ──────────────────────────────────────────────────
// Problem  : 496. Next Greater Element I
// Difficulty: Easy
// Tags     : Array, Hash Table, Stack, Monotonic Stack
// Link     : https://leetcode.com/problems/next-greater-element-i/
// Runtime  : 4 ms (beats 74%)
// Memory   : 44996000 (beats 66%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}