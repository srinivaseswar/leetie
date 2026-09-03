// ──────────────────────────────────────────────────
// Problem  : 421. Maximum XOR of Two Numbers in an Array
// Difficulty: Medium
// Tags     : Array, Hash Table, Bit Manipulation, Trie
// Link     : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42384000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        TrieNode root = new TrieNode();

        // Step 1: Insert all numbers into the Trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        // Step 2: For each number, find the max XOR by greedily taking opposite bits
        int maxXor = 0;
        for (int num : nums) {
            TrieNode node = root;
            int currentXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int oppositeBit = 1 - bit;

                // If opposite bit exists, go that direction to maximize XOR
                if (node.children[oppositeBit] != null) {
                    currentXor |= (1 << i);
                    node = node.children[oppositeBit];
                } else {
                    node = node.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }
}