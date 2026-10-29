// ──────────────────────────────────────────────────
// Problem  : 25. Reverse Nodes in k-Group
// Difficulty: Hard
// Tags     : Linked List, Recursion
// Link     : https://leetcode.com/problems/reverse-nodes-in-k-group/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45800000 (beats 95%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;

        // Check whether k nodes are available
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        // Reverse the first k nodes
        current = head;
        ListNode prev = null;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect the reversed groups
        head.next = reverseKGroup(current, k);

        return prev;
    }
}
