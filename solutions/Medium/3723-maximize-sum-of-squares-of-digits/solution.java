// ──────────────────────────────────────────────────
// Problem  : 3723. Maximize Sum of Squares of Digits
// Difficulty: Medium
// Tags     : Math, Greedy
// Link     : https://leetcode.com/problems/maximize-sum-of-squares-of-digits/
// Runtime  : 179 ms (beats 6%)
// Memory   : 47392000 (beats 99%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            sb.append(digit);
            sum -= digit;
        }
        
        // If there is still remaining sum, it's impossible to form the number
        if (sum > 0) {
            return "";
        }
        
        return sb.toString();
    }
}