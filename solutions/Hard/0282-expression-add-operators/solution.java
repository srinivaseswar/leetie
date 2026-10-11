// ──────────────────────────────────────────────────
// Problem  : 282. Expression Add Operators
// Difficulty: Hard
// Tags     : Math, String, Backtracking
// Link     : https://leetcode.com/problems/expression-add-operators/
// Runtime  : 141 ms (beats 8%)
// Memory   : 53264000 (beats 7%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void backtrack(String num, int target, int index, long eval, long prevVal, String path, List<String> result) {
        // Base case: if we have consumed all digits in 'num'
        if (index == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }

        // Iterate through all possible lengths for the current operand
        for (int i = index; i < num.length(); i++) {
            // Numbers cannot have leading zeros (e.g., "05" is invalid)
            if (i > index && num.charAt(index) == '0') break;

            String subStr = num.substring(index, i + 1);
            long currentVal = Long.parseLong(subStr);

            if (index == 0) {
                // First number in the expression doesn't have a preceding operator
                backtrack(num, target, i + 1, currentVal, currentVal, subStr, result);
            } else {
                // Try '+'
                backtrack(num, target, i + 1, eval + currentVal, currentVal, path + "+" + subStr, result);
                
                // Try '-'
                backtrack(num, target, i + 1, eval - currentVal, -currentVal, path + "-" + subStr, result);
                
                // Try '*'
                backtrack(num, target, i + 1, eval - prevVal + (prevVal * currentVal), prevVal * currentVal, path + "*" + subStr, result);
            }
        }
    }
}