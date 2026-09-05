// ──────────────────────────────────────────────────
// Problem  : 432. All O`one Data Structure
// Difficulty: Hard
// Tags     : Hash Table, Linked List, Design, Doubly-Linked List
// Link     : https://leetcode.com/problems/all-oone-data-structure/
// Runtime  : 79 ms (beats 53%)
// Memory   : 78780000 (beats 76%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> keyNodeMap;
    private Node head, tail; // Dummy nodes to simplify boundary operations

    public AllOne() {
        keyNodeMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (keyNodeMap.containsKey(key)) {
            Node currNode = keyNodeMap.get(key);
            Node nextNode = currNode.next;

            // Create or move key to node with count + 1
            if (nextNode == tail || nextNode.count != currNode.count + 1) {
                nextNode = addNodeAfter(currNode, currNode.count + 1);
            }

            nextNode.keys.add(key);
            keyNodeMap.put(key, nextNode);
            removeKeyFromNode(currNode, key);
        } else {
            // First insertion (count = 1)
            Node firstNode = head.next;
            if (firstNode == tail || firstNode.count != 1) {
                firstNode = addNodeAfter(head, 1);
            }

            firstNode.keys.add(key);
            keyNodeMap.put(key, firstNode);
        }
    }

    public void dec(String key) {
        Node currNode = keyNodeMap.get(key);

        if (currNode.count == 1) {
            keyNodeMap.remove(key);
        } else {
            Node prevNode = currNode.prev;
            if (prevNode == head || prevNode.count != currNode.count - 1) {
                prevNode = addNodeAfter(currNode.prev, currNode.count - 1);
            }

            prevNode.keys.add(key);
            keyNodeMap.put(key, prevNode);
        }

        removeKeyFromNode(currNode, key);
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    // Helper method to insert a new node into the doubly linked list
    private Node addNodeAfter(Node node, int count) {
        Node newNode = new Node(count);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        return newNode;
    }

    // Helper method to remove key and clean up empty nodes
    private void removeKeyFromNode(Node node, String key) {
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}