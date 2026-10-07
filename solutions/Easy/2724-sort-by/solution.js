// ──────────────────────────────────────────────────
// Problem  : 2724. Sort By
// Difficulty: Easy
// Tags     : N/A
// Link     : https://leetcode.com/problems/sort-by/
// Runtime  : 118 ms (beats 23%)
// Memory   : 69372000 (beats 78%)
// Language : javascript
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function(arr, fn) {
    return arr.sort((a, b) => fn(a) - fn(b));
};