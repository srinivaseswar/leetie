// ──────────────────────────────────────────────────
// Problem  : 318. Maximum Product of Word Lengths
// Difficulty: Medium
// Tags     : Array, String, Bit Manipulation
// Link     : https://leetcode.com/problems/maximum-product-of-word-lengths/
// Runtime  : 9 ms (beats 100%)
// Memory   : 49148000 (beats 75%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lengths = new int[n];

        // Step 1: Precompute bitmask and length for each word
        for (int i = 0; i < n; i++) {
            int bitmask = 0;
            for (char c : words[i].toCharArray()) {
                bitmask |= (1 << (c - 'a'));
            }
            masks[i] = bitmask;
            lengths[i] = words[i].length();
        }

        // Step 2: Compare pairs to find maximum product
        int maxProd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, lengths[i] * lengths[j]);
                }
            }
        }

        return maxProd;
    }
}