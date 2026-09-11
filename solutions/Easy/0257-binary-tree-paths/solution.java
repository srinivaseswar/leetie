// ──────────────────────────────────────────────────
// Problem  : 257. Binary Tree Paths
// Difficulty: Easy
// Tags     : String, Backtracking, Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/binary-tree-paths/
// Runtime  : 4 ms (beats 73%)
// Memory   : 49572000 (beats 52%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (path.isEmpty()) {
            path += node.val;
        } else {
            path += "->" + node.val;
        }

        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        if (node.left != null) {
            dfs(node.left, path, result);
        }
        if (node.right != null) {
            dfs(node.right, path, result);
        }
    }
}