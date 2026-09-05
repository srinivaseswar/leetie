// ──────────────────────────────────────────────────
// Problem  : 398. Random Pick Index
// Difficulty: Medium
// Tags     : Hash Table, Math, Reservoir Sampling, Randomized
// Link     : https://leetcode.com/problems/random-pick-index/
// Runtime  : 78 ms (beats 90%)
// Memory   : 71936000 (beats 38%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private Map<Integer, List<Integer>> indexMap;
    private Random random;

    public Solution(int[] nums) {
        indexMap = new HashMap<>();
        random = new Random();
        
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indices = indexMap.get(target);
        return indices.get(random.nextInt(indices.size()));
    }
}