// ──────────────────────────────────────────────────
// Problem  : 4415. Count Values With Equally Spaced Occurrences I
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-i/
// Runtime  : 5 ms (beats 100%)
// Memory   : 46600000 (beats 100%)
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
            if (indices.size() == 3) {
                int i1 = indices.get(0);
                int i2 = indices.get(1);
                int i3 = indices.get(2);
                
                if (i2 - i1 == i3 - i2) {
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
0
0