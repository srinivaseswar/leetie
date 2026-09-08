// ──────────────────────────────────────────────────
// Problem  : 222. Count Complete Tree Nodes
// Difficulty: Medium
// Tags     : Binary Search, Bit Manipulation, Tree, Binary Tree
// Link     : https://leetcode.com/problems/count-complete-tree-nodes/
// Runtime  : 0 ms (beats 100%)
// Memory   : 49292000 (beats 84%)
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            // Left subtree is perfect binary tree of depth leftDepth
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // Right subtree is perfect binary tree of depth rightDepth
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }
}