// ──────────────────────────────────────────────────
// Problem  : 234. Palindrome Linked List
// Difficulty: Easy
// Tags     : Linked List, Two Pointers, Stack, Recursion
// Link     : https://leetcode.com/problems/palindrome-linked-list/
// Runtime  : 4 ms (beats 68%)
// Memory   : 96824000 (beats 26%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfHead = head;

        // 3. Compare the two halves
        ListNode p1 = firstHalfHead;
        ListNode p2 = secondHalfHead;
        boolean isPalindrome = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. Restore the list (optional)
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}