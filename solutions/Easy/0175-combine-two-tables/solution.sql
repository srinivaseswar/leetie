-- ──────────────────────────────────────────────────
-- Problem  : 175. Combine Two Tables
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/combine-two-tables/
-- Runtime  : 406 ms (beats 85%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 srinivaseswar. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT 
    p.firstName, 
    p.lastName, 
    a.city, 
    a.state
FROM Person p
LEFT JOIN Address a 
    ON p.personId = a.personId;