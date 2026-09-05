// ──────────────────────────────────────────────────
// Problem  : 433. Minimum Genetic Mutation
// Difficulty: Medium
// Tags     : Hash Table, String, Breadth-First Search, Bidirectional Search
// Link     : https://leetcode.com/problems/minimum-genetic-mutation/
// Runtime  : 0 ms (beats 0%)
// Memory   : 42756000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        
        char[] geneChars = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) return mutations;
                
                char[] currArray = current.toCharArray();
                for (int j = 0; j < currArray.length; j++) {
                    char originalChar = currArray[j];
                    
                    for (char c : geneChars) {
                        if (c == originalChar) continue;
                        
                        currArray[j] = c;
                        String nextGene = String.valueOf(currArray);
                        
                        if (bankSet.contains(nextGene)) {
                            queue.offer(nextGene);
                            bankSet.remove(nextGene); // Mark as visited
                        }
                    }
                    
                    currArray[j] = originalChar; // Reset character
                }
            }
            
            mutations++;
        }
        
        return -1;
    }
}