// ──────────────────────────────────────────────────
// Problem  : 457. Circular Array Loop
// Difficulty: Medium
// Tags     : Array, Hash Table, Two Pointers, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/circular-array-loop/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42696000 (beats 75%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            // Slow and fast pointers
            int slow = i;
            int fast = i;

            // Determine if the loop is moving forward or backward
            boolean isForward = nums[i] > 0;

            while (true) {
                // Move slow pointer one step
                slow = getNextIndex(nums, slow, isForward);
                if (slow == -1) break;

                // Move fast pointer two steps
                fast = getNextIndex(nums, fast, isForward);
                if (fast == -1) break;
                fast = getNextIndex(nums, fast, isForward);
                if (fast == -1) break;

                // If slow and fast meet, we found a cycle
                if (slow == fast) {
                    // Check for a cycle of length 1 (self-loop)
                    if (slow == getNextIndex(nums, slow, isForward)) {
                        break;
                    }
                    return true;
                }
            }

            // Mark all nodes in this failed path as 0 (visited / dead-end)
            int curr = i;
            boolean currForward = nums[i] > 0;
            while (nums[curr] != 0 && (nums[curr] > 0) == currForward) {
                int next = getNextIndex(nums, curr, currForward);
                nums[curr] = 0;
                if (next == -1) break;
                curr = next;
            }
        }

        return false;
    }

    private int getNextIndex(int[] nums, int i, boolean isForward) {
        boolean direction = nums[i] > 0;
        // If direction changes, or it's already marked visited (0), invalid path
        if (direction != isForward || nums[i] == 0) {
            return -1;
        }
        int n = nums.length;
        int next = (i + nums[i]) % n;
        if (next < 0) {
            next += n;
        }
        // Self-loop of length 1
        if (next == i) {
            return -1;
        }
        return next;
    }
}