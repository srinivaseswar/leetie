// ──────────────────────────────────────────────────
// Problem  : 216. Combination Sum III
// Difficulty: Medium
// Tags     : Array, Backtracking
// Link     : https://leetcode.com/problems/combination-sum-iii/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42428000 (beats 48%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int target, int start) {
        // Base case: combination reached length k
        if (current.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // Try numbers from start to 9
        for (int i = start; i <= 9; i++) {
            if (i > target) {
                break; // Early pruning: current digit exceeds remaining sum
            }

            current.add(i);
            backtrack(result, current, k, target - i, i + 1);
            current.remove(current.size() - 1); // Undo choice
        }
    }
}