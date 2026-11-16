// ──────────────────────────────────────────────────
// Problem  : 2243. Calculate Digit Sum of a String
// Difficulty: Easy
// Tags     : String, Simulation
// Link     : https://leetcode.com/problems/calculate-digit-sum-of-a-string/
// Runtime  : 1 ms (beats 99%)
// Memory   : 42744000 (beats 63%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder nextS = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int end = Math.min(i + k, s.length());
                String group = s.substring(i, end);
                int sum = 0;
                for (int j = 0; j < group.length(); j++) {
                    sum += group.charAt(j) - '0';
                }
                nextS.append(sum);
            }
            s = nextS.toString();
        }
        return s;
    }
}