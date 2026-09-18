// ──────────────────────────────────────────────────
// Problem  : 3622. Check Divisibility by Digit Sum and Product
// Difficulty: Easy
// Tags     : Math
// Link     : https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/
// Runtime  : 1 ms (beats 25%)
// Memory   : 41984000 (beats 97%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int digitSum = 0;
        int digitProduct = 1;

        while (temp > 0) {
            int digit = temp % 10;
            digitSum += digit;
            digitProduct *= digit;
            temp /= 10;
        }

        int totalSum = digitSum + digitProduct;

        return n % totalSum == 0;
    }
}