// ──────────────────────────────────────────────────
// Problem  : 211. Design Add and Search Words Data Structure
// Difficulty: Medium
// Tags     : String, Depth-First Search, Design, Trie
// Link     : https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Runtime  : 231 ms (beats 31%)
// Memory   : 274156000 (beats 66%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class WordDictionary {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isWord;

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, index + 1, node.children[c - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */