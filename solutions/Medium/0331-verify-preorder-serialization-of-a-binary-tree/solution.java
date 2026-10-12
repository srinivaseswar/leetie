// ──────────────────────────────────────────────────
// Problem  : 331. Verify Preorder Serialization of a Binary Tree
// Difficulty: Medium
// Tags     : String, Stack, Tree, Binary Tree
// Link     : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// Runtime  : 4 ms (beats 97%)
// Memory   : 44756000 (beats 80%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1; // Start with 1 slot for the root
        
        for (String node : nodes) {
            slots--; // Every node consumes 1 slot
            
            // If slots drop below 0, we have too many children for the available parents
            if (slots < 0) {
                return false;
            }
            
            // If the node is not null, it creates 2 new child slots
            if (!node.equals("#")) {
                slots += 2;
            }
        }
        
        // All slots must be perfectly filled
        return slots == 0;
    }
}