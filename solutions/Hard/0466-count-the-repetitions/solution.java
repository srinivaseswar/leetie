// ──────────────────────────────────────────────────
// Problem  : 466. Count The Repetitions
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming
// Link     : https://leetcode.com/problems/count-the-repetitions/
// Runtime  : 1 ms (beats 100%)
// Memory   : 42624000 (beats 65%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int len1 = c1.length;
        int len2 = c2.length;
        
        // Track how many times s2 has been matched and the index in s2 for each s1 block
        // memo[i] = {count of s2 matched, ending index in s2} after completing (i + 1) blocks of s1
        int[] repeatCount = new int[len2 + 1];
        int[] nextIndex = new int[len2 + 1];
        
        int j = 0; // index in s2
        int count2 = 0; // total matched s2 strings
        
        for (int k = 0; k < n1; k++) {
            for (int i = 0; i < len1; i++) {
                if (c1[i] == c2[j]) {
                    j++;
                    if (j == len2) {
                        j = 0;
                        count2++;
                    }
                }
            }
            
            repeatCount[k] = count2;
            nextIndex[k] = j;
            
            // Check if we've seen this index j before to find a cycle
            for (int start = 0; start < k; start++) {
                if (nextIndex[start] == j) {
                    // Found a cycle!
                    int prevCount = repeatCount[start];
                    int cycleCount = count2 - prevCount;
                    int cycleLength = k - start;
                    
                    // Number of remaining cycles we can skip
                    int remainingCycles = (n1 - 1 - start) / cycleLength;
                    int finalCount2 = prevCount + remainingCycles * cycleCount;
                    
                    // Simulate the remaining tail part after skipping full cycles
                    int tailBlocks = (n1 - 1 - start) % cycleLength;
                    int tailCount2 = repeatCount[start + tailBlocks] - prevCount;
                    
                    return (finalCount2 + tailCount2) / n2;
                }
            }
        }
        
        return count2 / n2;
    }
}