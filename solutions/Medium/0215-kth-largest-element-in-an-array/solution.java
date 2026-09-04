// ──────────────────────────────────────────────────
// Problem  : 215. Kth Largest Element in an Array
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Sorting, Heap (Priority Queue), Quickselect
// Link     : https://leetcode.com/problems/kth-largest-element-in-an-array/
// Runtime  : 72 ms (beats 27%)
// Memory   : 78632000 (beats 5%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}