// ──────────────────────────────────────────────────
// Problem  : 406. Queue Reconstruction by Height
// Difficulty: Medium
// Tags     : Array, Binary Indexed Tree, Segment Tree, Sorting
// Link     : https://leetcode.com/problems/queue-reconstruction-by-height/
// Runtime  : 6 ms (beats 99%)
// Memory   : 47536000 (beats 13%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort: descending height, ascending k-value
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person); // Insert at index k
        }
        
        return result.toArray(new int[people.length][]);
    }
}