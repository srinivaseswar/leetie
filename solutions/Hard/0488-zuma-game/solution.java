// ──────────────────────────────────────────────────
// Problem  : 488. Zuma Game
// Difficulty: Hard
// Tags     : String, Dynamic Programming, Stack, Breadth-First Search, Memoization
// Link     : https://leetcode.com/problems/zuma-game/
// Runtime  : 297 ms (beats 29%)
// Memory   : 58168000 (beats 40%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    private Map<String, Integer> memo;

    public int findMinStep(String board, String hand) {
        memo = new HashMap<>();
        // Sort hand to ensure consistent state keys for memoization
        char[] handChars = hand.toCharArray();
        Arrays.sort(handChars);
        
        int result = dfs(board, new String(handChars));
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String board, String hand) {
        board = cleanBoard(board);
        if (board.length() == 0) return 0;
        if (hand.length() == 0) return Integer.MAX_VALUE;

        String key = board + "#" + hand;
        if (memo.containsKey(key)) return memo.get(key);

        int minSteps = Integer.MAX_VALUE;

        // Try using each ball in the hand
        for (int i = 0; i < hand.length(); i++) {
            // Skip duplicate balls in hand to avoid redundant branches
            if (i > 0 && hand.charAt(i) == hand.charAt(i - 1)) continue;

            char ball = hand.charAt(i);
            String nextHand = hand.substring(0, i) + hand.substring(i + 1);

            // Try inserting the ball at valid positions on the board
            for (int j = 0; j <= board.length(); j++) {
                // Optimization heuristic: only insert if it matches the adjacent board color
                // or if it helps clear a group of 2.
                if (j > 0 && board.charAt(j - 1) == ball) continue; // Skip redundant consecutive identical insertions

                boolean shouldInsert = false;
                if (j < board.length() && board.charAt(j) == ball) {
                    shouldInsert = true;
                } else if (j > 0 && j < board.length() && board.charAt(j - 1) == board.charAt(j) && board.charAt(j - 1) != ball) {
                    shouldInsert = true;
                } else if (j == 0 && board.length() > 0 && board.charAt(0) == ball) {
                    shouldInsert = true;
                }

                // If board is empty or matches criteria, try the placement
                if (board.length() == 0 || shouldInsert || (j > 0 && j < board.length() && board.charAt(j-1) == ball)) {
                    String nextBoard = board.substring(0, j) + ball + board.substring(j);
                    int res = dfs(nextBoard, nextHand);
                    if (res != Integer.MAX_VALUE) {
                        minSteps = Math.min(minSteps, res + 1);
                    }
                }
            }
        }

        memo.put(key, minSteps);
        return minSteps;
    }

    private String cleanBoard(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean changed = true;
        while (changed) {
            changed = false;
            int n = sb.length();
            int i = 0;
            while (i < n) {
                int j = i;
                while (j < n && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }
                if (j - i >= 3) {
                    sb.delete(i, j);
                    changed = true;
                    break;
                }
                i = j;
            }
        }
        return sb.toString();
    }
}