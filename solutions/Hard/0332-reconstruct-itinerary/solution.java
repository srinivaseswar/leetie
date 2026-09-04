// ──────────────────────────────────────────────────
// Problem  : 332. Reconstruct Itinerary
// Difficulty: Hard
// Tags     : Array, String, Depth-First Search, Graph Theory, Sorting, Heap (Priority Queue), Eulerian Circuit, Eulerian Path, Semi-Eulerian Graph
// Link     : https://leetcode.com/problems/reconstruct-itinerary/
// Runtime  : 6 ms (beats 77%)
// Memory   : 47512000 (beats 14%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        // Build graph with min-heap for lexical ordering
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        
        return itinerary;
    }
    
    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);
        
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), graph, itinerary);
        }
        
        // Post-order insertion builds path backwards
        itinerary.addFirst(airport);
    }
}