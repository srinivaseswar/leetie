// ──────────────────────────────────────────────────
// Problem  : 232. Implement Queue using Stacks
// Difficulty: Easy
// Tags     : Stack, Design, Queue
// Link     : https://leetcode.com/problems/implement-queue-using-stacks/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42968000 (beats 15%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        moveInToOut();
        return outStack.pop();
    }
    
    public int peek() {
        moveInToOut();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void moveInToOut() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}