// ──────────────────────────────────────────────────
// Problem  : 207. Course Schedule
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort, Directed Acyclic Graph
// Link     : https://leetcode.com/problems/course-schedule/
// Runtime  : 6 ms (beats 72%)
// Memory   : 46936000 (beats 78%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] req : prerequisites) {
            int course = req[0];
            int prereq = req[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int processedCount = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            processedCount++;
            
            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return processedCount == numCourses;
    }
}