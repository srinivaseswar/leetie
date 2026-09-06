// ──────────────────────────────────────────────────
// Problem  : 382. Linked List Random Node
// Difficulty: Medium
// Tags     : Linked List, Math, Reservoir Sampling, Randomized
// Link     : https://leetcode.com/problems/linked-list-random-node/
// Runtime  : 12 ms (beats 59%)
// Memory   : 48372000 (beats 50%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Random;

class Solution {
    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    public int getRandom() {
        ListNode curr = head;
        int result = curr.val;
        int count = 1;
        
        while (curr != null) {
            // Pick a random integer in range [0, count - 1]
            if (rand.nextInt(count) == 0) {
                result = curr.val;
            }
            count++;
            curr = curr.next;
        }
        
        return result;
    }
}