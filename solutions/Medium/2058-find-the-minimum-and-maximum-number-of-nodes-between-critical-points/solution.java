// ──────────────────────────────────────────────────
// Problem  : 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
// Difficulty: Medium
// Tags     : Linked List
// Link     : https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
// Runtime  : 4 ms (beats 100%)
// Memory   : 106072000 (beats 70%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
                if (head == null || head.next == null || head.next.next == null) {
                            return new int[]{-1, -1};
                                    }

                                            ListNode prev = head;
                                                    ListNode curr = head.next;
                                                            int index = 1; // index of curr node (0-indexed base node head is 0)

                                                                    int firstIndex = -1;
                                                                            int prevIndex = -1;
                                                                                    int minDistance = Integer.MAX_VALUE;

                                                                                            while (curr.next != null) {
                                                                                                        ListNode next = curr.next;

                                                                                                                    // Check if current node is a critical point
                                                                                                                                if ((curr.val > prev.val && curr.val > next.val) || 
                                                                                                                                                (curr.val < prev.val && curr.val < next.val)) {
                                                                                                                                                                
                                                                                                                                                                                if (firstIndex == -1) {
                                                                                                                                                                                                    firstIndex = index;
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                        minDistance = Math.min(minDistance, index - prevIndex);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        prevIndex = index;
                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                prev = curr;
                                                                                                                                                                                                                                                                                                            curr = next;
                                                                                                                                                                                                                                                                                                                        index++;
                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                        // If fewer than 2 critical points were found
                                                                                                                                                                                                                                                                                                                                                if (firstIndex == -1 || prevIndex == firstIndex) {
                                                                                                                                                                                                                                                                                                                                                            return new int[]{-1, -1};
                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                            int maxDistance = prevIndex - firstIndex;
                                                                                                                                                                                                                                                                                                                                                                                    return new int[]{minDistance, maxDistance};
                                                                                                                                                                                                                                                                                                                                                                                        }
}
