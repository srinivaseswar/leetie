// ──────────────────────────────────────────────────
// Problem  : 307. Range Sum Query - Mutable
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Design, Binary Indexed Tree, Segment Tree, Sqrt Decomposition
// Link     : https://leetcode.com/problems/range-sum-query-mutable/
// Runtime  : 74 ms (beats 79%)
// Memory   : 134684000 (beats 25%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.tree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        
        for (int i = index + 1; i <= n; i += i & -i) {
            tree[i] += delta;
        }
    }
    
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private int query(int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= i & -i) {
            sum += tree[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */