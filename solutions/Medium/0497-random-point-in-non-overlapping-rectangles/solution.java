// ──────────────────────────────────────────────────
// Problem  : 497. Random Point in Non-overlapping Rectangles
// Difficulty: Medium
// Tags     : Array, Math, Binary Search, Reservoir Sampling, Prefix Sum, Ordered Set, Randomized
// Link     : https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
// Runtime  : 62 ms (beats 6%)
// Memory   : 52180000 (beats 89%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    int[][] rects;
    long[] prefix;
    long total = 0;
    Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        prefix = new long[rects.length];

        for (int i = 0; i < rects.length; i++) {
            long points = (long) (rects[i][2] - rects[i][0] + 1)
                        * (rects[i][3] - rects[i][1] + 1);

            total += points;
            prefix[i] = total;
        }
    }

    public int[] pick() {
        long rand = random.nextLong(total) + 1;

        int left = 0, right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] < rand) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int[] r = rects[left];

        int x = r[0] + random.nextInt(r[2] - r[0] + 1);
        int y = r[1] + random.nextInt(r[3] - r[1] + 1);

        return new int[]{x, y};
    }
}