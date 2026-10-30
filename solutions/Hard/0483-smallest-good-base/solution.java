// ──────────────────────────────────────────────────
// Problem  : 483. Smallest Good Base
// Difficulty: Hard
// Tags     : Math, Binary Search
// Link     : https://leetcode.com/problems/smallest-good-base/
// Runtime  : 19 ms (beats 5%)
// Memory   : 46352000 (beats 6%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.math.BigInteger;

class Solution {
    public String smallestGoodBase(String nStr) {
        long n = Long.parseLong(nStr);
        
        // Maximum possible number of 1s is log2(n), which is at most 59 for n <= 10^18
        int maxM = (int) (Math.log(n + 1) / Math.log(2));
        
        // Try m from maxM down to 2
        for (int m = maxM; m >= 2; m--) {
            // Lower bound for k is 2, upper bound is roughly n^(1 / (m - 1))
            long low = 2;
            long high = (long) Math.pow(n, 1.0 / (m - 1)) + 1;
            
            while (low <= high) {
                long k = low + (high - low) / 2;
                
                // Evaluate sum: 1 + k + k^2 + ... + k^(m-1)
                BigInteger sum = BigInteger.ZERO;
                BigInteger currentPower = BigInteger.ONE;
                BigInteger bk = BigInteger.valueOf(k);
                BigInteger bn = BigInteger.valueOf(n);
                
                boolean overflow = false;
                for (int i = 0; i < m; i++) {
                    sum = sum.add(currentPower);
                    if (sum.compareTo(bn) > 0) {
                        overflow = true;
                        break;
                    }
                    if (i < m - 1) {
                        currentPower = currentPower.multiply(bk);
                    }
                }
                
                if (!overflow && sum.compareTo(bn) == 0) {
                    return String.valueOf(k);
                } else if (overflow || sum.compareTo(bn) > 0) {
                    high = k - 1;
                } else {
                    low = k + 1;
                }
            }
        }
        
        // Fallback (every number n has a trivial base of n - 1, since n in base (n - 1) is "11")
        return String.valueOf(n - 1);
    }
}