// ──────────────────────────────────────────────────
// Problem  : 381. Insert Delete GetRandom O(1) - Duplicates allowed
// Difficulty: Hard
// Tags     : Array, Hash Table, Math, Design, Randomized
// Link     : https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
// Runtime  : 36 ms (beats 17%)
// Memory   : 100488000 (beats 8%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val) || map.get(val).isEmpty();
        
        map.computeIfAbsent(val, k -> new LinkedHashSet<>()).add(list.size());
        list.add(val);
        
        return notPresent;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        
        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);
        
        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);
        
        if (removeIdx != lastIdx) {
            list.set(removeIdx, lastVal);
            map.get(lastVal).remove(lastIdx);
            map.get(lastVal).add(removeIdx);
        }
        
        // Remove last element
        list.remove(lastIdx);
        
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}