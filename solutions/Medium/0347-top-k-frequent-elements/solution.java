// ──────────────────────────────────────────────────
// Problem  : 347. Top K Frequent Elements
// Difficulty: Medium
// Tags     : Array, Hash Table, Divide and Conquer, Sorting, Heap (Priority Queue), Bucket Sort, Counting, Quickselect
// Link     : https://leetcode.com/problems/top-k-frequent-elements/
// Runtime  : 11 ms (beats 96%)
// Memory   : 47404000 (beats 82%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Bucket array where index represents frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : countMap.keySet()) {
            int frequency = countMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        
        // Gather the top k frequent elements from highest to lowest bucket
        int[] result = new int[k];
        int index = 0;
        
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }
        
        return result;
    }
}