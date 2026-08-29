// ──────────────────────────────────────────────────
// Problem  : 2948. Make Lexicographically Smallest Array by Swapping Elements
// Difficulty: Medium
// Tags     : Array, Union-Find, Sorting
// Link     : https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
// Runtime  : 89 ms (beats 58%)
// Memory   : 118864000 (beats 95%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;
                    int[][] pairs = new int[n][2];
                            for (int i = 0; i < n; i++) {
                                        pairs[i] = new int[]{nums[i], i};
                                                }

                                                        // Sort elements by value
                                                                Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

                                                                        int[] result = new int[n];
                                                                                int i = 0;

                                                                                        while (i < n) {
                                                                                                    int j = i;
                                                                                                                List<Integer> values = new ArrayList<>();
                                                                                                                            List<Integer> indices = new ArrayList<>();

                                                                                                                                        // Find all elements belonging to the same connected component
                                                                                                                                                    while (j < n && (j == i || pairs[j][0] - pairs[j - 1][0] <= limit)) {
                                                                                                                                                                    values.add(pairs[j][0]);
                                                                                                                                                                                    indices.add(pairs[j][1]);
                                                                                                                                                                                                    j++;
                                                                                                                                                                                                                }

                                                                                                                                                                                                                            // Sort original indices to place smallest values in leftmost available slots
                                                                                                                                                                                                                                        Collections.sort(indices);

                                                                                                                                                                                                                                                    for (int k = 0; k < values.size(); k++) {
                                                                                                                                                                                                                                                                    result[indices.get(k)] = values.get(k);
                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                            i = j;
                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                            return result;
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                }