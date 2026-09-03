// ──────────────────────────────────────────────────
// Problem  : 220. Contains Duplicate III
// Difficulty: Hard
// Tags     : Array, Sliding Window, Sorting, Bucket Sort, Ordered Set
// Link     : https://leetcode.com/problems/contains-duplicate-iii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42788000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();
        long w = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long val = (long) nums[i];
            long bucketId = getBucketId(val, w);

            // Check if current bucket already has a value
            if (buckets.containsKey(bucketId)) {
                return true;
            }
            // Check adjacent left bucket
            if (buckets.containsKey(bucketId - 1) && Math.abs(val - buckets.get(bucketId - 1)) <= valueDiff) {
                return true;
            }
            // Check adjacent right bucket
            if (buckets.containsKey(bucketId + 1) && Math.abs(val - buckets.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            buckets.put(bucketId, val);

            // Maintain sliding window of size indexDiff
            if (i >= indexDiff) {
                long removeVal = (long) nums[i - indexDiff];
                long removeBucketId = getBucketId(removeVal, w);
                buckets.remove(removeBucketId);
            }
        }

        return false;
    }

    private long getBucketId(long val, long w) {
        if (val >= 0) {
            return val / w;
        } else {
            return (val + 1) / w - 1;
        }
    }
}