// ──────────────────────────────────────────────────
// Problem  : 295. Find Median from Data Stream
// Difficulty: Hard
// Tags     : Two Pointers, Design, Sorting, Heap (Priority Queue), Data Stream
// Link     : https://leetcode.com/problems/find-median-from-data-stream/
// Runtime  : 164 ms (beats 44%)
// Memory   : 111508000 (beats 37%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // stores lower half
    private PriorityQueue<Integer> minHeap; // stores upper half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        
        // Ensure maxHeap's max element <= minHeap's min element
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        
        // Maintain size balance (maxHeap can have at most 1 more element than minHeap)
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}