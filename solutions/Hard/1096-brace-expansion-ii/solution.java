// ──────────────────────────────────────────────────
// Problem  : 1096. Brace Expansion II
// Difficulty: Hard
// Tags     : Hash Table, String, Backtracking, Stack, Breadth-First Search, Sorting
// Link     : https://leetcode.com/problems/brace-expansion-ii/
// Runtime  : 11 ms (beats 47%)
// Memory   : 47224000 (beats 54%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    private int i = 0;

    public List<String> braceExpansionII(String expression) {
        i = 0;
        Set<String> resultSet = parse(expression);
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }

    private Set<String> parse(String expr) {
        List<Set<String>> groups = new ArrayList<>(); 
        List<Set<String>> cur = new ArrayList<>();    

        while (i < expr.length()) {
            char c = expr.charAt(i);

            if (c == '{') {
                i++; // Skip '{'
                Set<String> subSet = parse(expr);
                cur.add(subSet);
            } else if (c == '}') {
                i++; // Skip '}'
                break;
            } else if (c == ',') {
                i++; // Skip ','
                groups.add(combineProduct(cur));
                cur = new ArrayList<>();
            } else {
                // Single letter
                Set<String> letterSet = new HashSet<>();
                letterSet.add(String.valueOf(c));
                cur.add(letterSet);
                i++;
            }
        }

        if (!cur.isEmpty()) {
            groups.add(combineProduct(cur));
        }

        Set<String> unionSet = new HashSet<>();
        for (Set<String> group : groups) {
            unionSet.addAll(group);
        }

        return unionSet;
    }

    private Set<String> combineProduct(List<Set<String>> list) {
        Set<String> res = new HashSet<>();
        if (list.isEmpty()) return res;

        res.add("");
        for (Set<String> set : list) {
            Set<String> next = new HashSet<>();
            for (String a : res) {
                for (String b : set) {
                    next.add(a + b);
                }
            }
            res = next;
        }

        return res;
    }
}