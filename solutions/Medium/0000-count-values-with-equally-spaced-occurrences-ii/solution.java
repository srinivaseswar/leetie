// ──────────────────────────────────────────────────
// Problem  : 0. Count Values With Equally Spaced Occurrences II
// Difficulty: Medium
// Tags     : N/A
// Link     : https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-ii/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42884000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        int specialCount = 0;
        
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                int diff = indices.get(1) - indices.get(0);
                boolean isEquallySpaced = true;
                
                for (int j = 2; j < indices.size(); j++) {
                    if (indices.get(j) - indices.get(j - 1) != diff) {
                        isEquallySpaced = false;
                        break;
                    }
                }
                
                if (isEquallySpaced) {
                    specialCount++;
                }
            }
        }
        
        return specialCount;
    }
}
[1,8,1,5,1,5,8,5]
[8,8,8,8]
[8,6,6,8,8]

[1,8,1,5,1,5,8,5]
[8,8,8,8]
[8,6,6,8,8]
2
1
0