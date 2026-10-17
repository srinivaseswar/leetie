// ──────────────────────────────────────────────────
// Problem  : 3551. Minimum Swaps to Sort by Digit Sum
// Difficulty: Medium
// Tags     : Array, Hash Table, Sorting
// Link     : https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/
// Runtime  : 228 ms (beats 99%)
// Memory   : 118164000 (beats 59%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    
    // Helper method to calculate the sum of digits of a number
    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Array of custom nodes to store value, original index, and digit sum
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums[i], getDigitSum(nums[i]), i);
        }
        
        // Sort based on digit sum, then by value
        Arrays.sort(nodes, (a, b) -> {
            if (a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.val, b.val);
        });
        
        // Find the number of cycles to compute minimum swaps
        boolean[] visited = new boolean[n];
        int cycles = 0;
        
        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position
            if (visited[i] || nodes[i].origIndex == i) {
                continue;
            }
            
            // Traverse the cycle
            int curr = i;
            int cycleSize = 0;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = nodes[curr].origIndex;
                cycleSize++;
            }
            
            if (cycleSize > 1) {
                cycles += (cycleSize - 1);
            }
        }
        
        return cycles;
    }
    
    private static class Node {
        int val;
        int digitSum;
        int origIndex;
        
        Node(int val, int digitSum, int origIndex) {
            this.val = val;
            this.digitSum = digitSum;
            this.origIndex = origIndex;
        }
    }
}