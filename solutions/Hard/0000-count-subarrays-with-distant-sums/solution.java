// ──────────────────────────────────────────────────
// Problem  : 0. Count Subarrays with Distant Sums
// Difficulty: Hard
// Tags     : N/A
// Link     : https://leetcode.com/problems/count-subarrays-with-distant-sums/
// Runtime  : 1 ms (beats 0%)
// Memory   : 42904000 (beats 0%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

                l = mid + 1;
            }
        }

        return l;
    }

    static class Fenwick {
        long[] tree;

        Fenwick(int n) {
            tree = new long[n + 1];
        }

        void add(int index, long value) {
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long sum(int index) {
            long res = 0;

            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }

            return res;
        }
    }
}

[1,2,1]
4
1
[2,-1,3]
2
2
[-3,1,2]
0
3
[1,2,1]
4
1
[2,-1,3]
2
2
[-3,1,2]
0
3
5
2
2