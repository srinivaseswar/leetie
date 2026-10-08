-- ──────────────────────────────────────────────────
-- Problem  : 577. Employee Bonus
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/employee-bonus/
-- Runtime  : 936 ms (beats 91%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 srinivaseswar. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT
e.name,
b.bonus
FROM 
Employee e
LEFT JOIN
Bonus b ON e.empId = b.empId
WHERE   
b.bonus < 1000
OR b.bonus IS NULL;