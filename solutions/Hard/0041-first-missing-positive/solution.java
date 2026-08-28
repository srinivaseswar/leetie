// ──────────────────────────────────────────────────
// Problem  : 41. First Missing Positive
// Difficulty: Hard
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/first-missing-positive/
// Runtime  : 1 ms (beats 100%)
// Memory   : 71368000 (beats 48%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
        public int firstMissingPositive(int[] nums) {
                int n = nums.length;
                        
                                // Place each number in its target index: number x should be at index x - 1
                                        for (int i = 0; i < n; i++) {
                                                    while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                                                                    // Swap nums[i] with nums[nums[i] - 1]
                                                                                    int correctIdx = nums[i] - 1;
                                                                                                    int temp = nums[i];
                                                                                                                    nums[i] = nums[correctIdx];
                                                                                                                                    nums[correctIdx] = temp;
                                                                                                                                                }
                                                                                                                                                        }
                                                                                                                                                                
                                                                                                                                                                        // Find the first index where the number is not equal to index + 1
                                                                                                                                                                                for (int i = 0; i < n; i++) {
                                                                                                                                                                                            if (nums[i] != i + 1) {
                                                                                                                                                                                                            return i + 1;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                // If all 1 to n are present, the answer is n + 1
                                                                                                                                                                                                                                                        return n + 1;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            }
