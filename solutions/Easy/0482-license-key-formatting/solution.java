// ──────────────────────────────────────────────────
// Problem  : 482. License Key Formatting
// Difficulty: Easy
// Tags     : String
// Link     : https://leetcode.com/problems/license-key-formatting/
// Runtime  : 12 ms (beats 54%)
// Memory   : 46000000 (beats 86%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        // Step 1: Traverse backwards, ignoring dashes and converting to uppercase
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
            }
        }
        
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        // Step 2: Insert dashes every 'k' characters
        for (int i = 0; i < sb.length(); i++) {
            if (count > 0 && count % k == 0) {
                result.append('-');
            }
            result.append(sb.charAt(i));
            count++;
        }
        
        // Step 3: Reverse back to the correct orientation
        return result.reverse().toString();
    }
}