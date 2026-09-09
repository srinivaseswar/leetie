// ──────────────────────────────────────────────────
// Problem  : 199. Binary Tree Right Side View
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Breadth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-right-side-view/
// Runtime  : 0 ms (beats 100%)
// Memory   : 43420000 (beats 84%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If this is the first node visited at the current depth, add it to the result
        if (level == result.size()) {
            result.add(node.val);
        }

        // Prioritize visiting the right subtree first
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}