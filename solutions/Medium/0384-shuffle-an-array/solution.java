// ──────────────────────────────────────────────────
// Problem  : 384. Shuffle an Array
// Difficulty: Medium
// Tags     : Array, Math, Design, Randomized
// Link     : https://leetcode.com/problems/shuffle-an-array/
// Runtime  : 5 ms (beats 0%)
// Memory   : 42940000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;

class Solution {
    private int[] original;
    private int[] array;
    private Random rand;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.array = nums.clone();
        this.rand = new Random();
    }
    
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            // Pick a random index between i and array.length - 1
            int randIndex = i + rand.nextInt(array.length - i);
            
            // Swap array[i] and array[randIndex]
            int temp = array[i];
            array[i] = array[randIndex];
            array[randIndex] = temp;
        }
        return array;
    }
}