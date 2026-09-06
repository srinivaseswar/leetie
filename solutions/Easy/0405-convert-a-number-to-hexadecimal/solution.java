// ──────────────────────────────────────────────────
// Problem  : 405. Convert a Number to Hexadecimal
// Difficulty: Easy
// Tags     : Math, String, Bit Manipulation
// Link     : https://leetcode.com/problems/convert-a-number-to-hexadecimal/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42824000 (beats 11%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0 && sb.length() < 8) {
            sb.append(hexChars[num & 15]); // 15 is 0xF
            num >>>= 4; // Logical right shift (fills with 0s)
        }

        return sb.reverse().toString();
    }
}