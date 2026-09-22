// ──────────────────────────────────────────────────
// Problem  : 3525. Find X Value of Array II
// Difficulty: Hard
// Tags     : Array, Math, Segment Tree
// Link     : https://leetcode.com/problems/find-x-value-of-array-ii/
// Runtime  : 270 ms (beats 26%)
// Memory   : 283728000 (beats 26%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    static class Node {
        int prod;
        long[] count;

        Node(int k) {
            this.prod = 1;
            this.count = new long[k];
        }
    }

    private Node[] tree;
    private int n;
    private int K;

    private Node merge(Node left, Node right) {
        Node res = new Node(K);
        res.prod = (int) (((long) left.prod * right.prod) % K);

        for (int i = 0; i < K; i++) {
            res.count[i] = left.count[i];
        }

        for (int y = 0; y < K; y++) {
            if (right.count[y] > 0) {
                int newRem = (int) (((long) left.prod * y) % K);
                res.count[newRem] += right.count[y];
            }
        }

        return res;
    }

    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            int val = (int) (nums[start] % K);
            tree[node].prod = val;
            tree[node].count[val] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(nums, node * 2, start, mid);
        build(nums, node * 2 + 1, mid + 1, end);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int rem = val % K;
            tree[node].prod = rem;
            for (int i = 0; i < K; i++) tree[node].count[i] = 0;
            tree[node].count[rem] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(node * 2, start, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return null;
        if (l <= start && end <= r) return tree[node];

        int mid = start + (end - start) / 2;
        Node leftRes = query(node * 2, start, mid, l, r);
        Node rightRes = query(node * 2 + 1, mid + 1, end, l, r);

        if (leftRes == null) return rightRes;
        if (rightRes == null) return leftRes;

        return merge(leftRes, rightRes);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.K = k;
        this.tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node(K);
        }

        build(nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            int val = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            
            update(1, 0, n - 1, idx, val);

            
            Node resNode = query(1, 0, n - 1, start, n - 1);
            ans[q] = (int) (resNode != null ? resNode.count[x] : 0);
        }

        return ans;
    }
}