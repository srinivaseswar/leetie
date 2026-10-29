// ──────────────────────────────────────────────────
// Problem  : 464. Can I Win
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Bit Manipulation, Memoization, Game Theory, Bitmask
// Link     : https://leetcode.com/problems/can-i-win/
// Runtime  : 306 ms (beats 53%)
// Memory   : 107436000 (beats 44%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Boolean> memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // Edge case: sum of all available numbers is less than desiredTotal
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }

        memo = new HashMap<>();
        return canWin(maxChoosableInteger, desiredTotal, 0);
    }

    private boolean canWin(int maxChoosableInteger, int desiredTotal, int state) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }

        // Try every available number from 1 to maxChoosableInteger
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int bit = 1 << (i - 1);
            // Check if the number 'i' has not been chosen yet
            if ((state & bit) == 0) {
                // If choosing 'i' reaches or exceeds desiredTotal, or forces opponent to lose
                if (i >= desiredTotal || !canWin(maxChoosableInteger, desiredTotal - i, state | bit)) {
                    memo.put(state, true);
                    return true;
                }
            }
        }

        memo.put(state, false);
        return false;
    }
}