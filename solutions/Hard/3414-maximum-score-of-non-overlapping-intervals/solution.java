// ──────────────────────────────────────────────────
// Problem  : 3414. Maximum Score of Non-overlapping Intervals
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Sorting
// Link     : https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
// Runtime  : 87 ms (beats 94%)
// Memory   : 161712000 (beats 93%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    private static class Interval {
        int l, r, weight, id;
        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervalsList.get(i);
            intervals[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }

        // Sort by right boundary r
        Arrays.sort(intervals, (a, b) -> {
            if (a.r != b.r) return Integer.compare(a.r, b.r);
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            return Integer.compare(a.id, b.id);
        });

        // Precompute largest index j where intervals[j].r < intervals[i].l
        int[] prevIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int low = 0, high = i - 1, ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (intervals[mid].r < intervals[i].l) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            prevIdx[i] = ans;
        }

        long[][] dp = new long[5][n];
        int[][] parent = new int[5][n];

        for (int k = 1; k <= 4; k++) {
            for (int i = 0; i < n; i++) {
                // Option 1: Skip interval i
                long skipScore = (i > 0) ? dp[k][i - 1] : 0;
                
                // Option 2: Take interval i
                int p = prevIdx[i];
                long takeScore = intervals[i].weight + ((p != -1) ? dp[k - 1][p] : 0);

                if (takeScore > skipScore) {
                    dp[k][i] = takeScore;
                    parent[k][i] = i;
                } else if (skipScore > takeScore) {
                    dp[k][i] = skipScore;
                    parent[k][i] = (i > 0) ? parent[k][i - 1] : -1;
                } else {
                    // Tie-break: compare correctly sorted lists lexicographically
                    List<Integer> skipList = reconstruct(k, (i > 0) ? parent[k][i - 1] : -1, intervals, parent, prevIdx);
                    List<Integer> takeList = reconstruct(k - 1, (p != -1) ? parent[k - 1][p] : -1, intervals, parent, prevIdx);
                    takeList.add(intervals[i].id);
                    Collections.sort(takeList);

                    if (compareLexicographically(takeList, skipList) < 0) {
                        dp[k][i] = takeScore;
                        parent[k][i] = i;
                    } else {
                        dp[k][i] = skipScore;
                        parent[k][i] = (i > 0) ? parent[k][i - 1] : -1;
                    }
                }
            }
        }

        List<Integer> resList = reconstruct(4, parent[4][n - 1], intervals, parent, prevIdx);
        
        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        return result;
    }

    private List<Integer> reconstruct(int k, int currIdx, Interval[] intervals, int[][] parent, int[] prevIdx) {
        List<Integer> list = new ArrayList<>();
        int curr = currIdx;
        int rem = k;

        while (curr != -1 && rem > 0) {
            list.add(intervals[curr].id);
            int p = prevIdx[curr];
            curr = (p != -1) ? parent[rem - 1][p] : -1;
            rem--;
        }
        Collections.sort(list); // Ensures candidate list is strictly sorted before comparisons
        return list;
    }

    private int compareLexicographically(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return Integer.compare(a.size(), b.size());
    }
}