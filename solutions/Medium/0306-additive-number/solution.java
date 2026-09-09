// ──────────────────────────────────────────────────
// Problem  : 306. Additive Number
// Difficulty: Medium
// Tags     : String, Backtracking
// Link     : https://leetcode.com/problems/additive-number/
// Runtime  : 4 ms (beats 35%)
// Memory   : 43240000 (beats 27%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        
        // i and j are the lengths of the first two numbers
        for (int i = 1; i <= n / 2; i++) {
            // A number with length > 1 cannot start with '0'
            if (num.charAt(0) == '0' && i > 1) break;
            
            for (int j = 1; n - i - j >= Math.max(i, j); j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                
                String num1Str = num.substring(0, i);
                String num2Str = num.substring(i, i + j);
                
                if (isValid(num1Str, num2Str, i + j, num)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean isValid(String num1Str, String num2Str, int k, String num) {
        BigInteger n1 = new BigInteger(num1Str);
        BigInteger n2 = new BigInteger(num2Str);
        
        while (k < num.length()) {
            BigInteger sum = n1.add(n2);
            String sumStr = sum.toString();
            
            if (!num.startsWith(sumStr, k)) {
                return false;
            }
            
            k += sumStr.length();
            n1 = n2;
            n2 = sum;
        }
        
        return true;
    }
}