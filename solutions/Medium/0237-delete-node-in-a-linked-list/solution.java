// ──────────────────────────────────────────────────
// Problem  : 237. Delete Node in a Linked List
// Difficulty: Medium
// Tags     : Linked List
// Link     : https://leetcode.com/problems/delete-node-in-a-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44992000 (beats 90%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}