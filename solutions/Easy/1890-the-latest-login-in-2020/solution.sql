-- ──────────────────────────────────────────────────
-- Problem  : 1890. The Latest Login in 2020
-- Difficulty: Easy
-- Tags     : Database
-- Link     : https://leetcode.com/problems/the-latest-login-in-2020/
-- Runtime  : 646 ms (beats 80%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 srinivaseswar. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

# Write your MySQL query statement below
SELECT 
    user_id, 
    MAX(time_stamp) AS last_stamp
FROM 
    Logins
WHERE 
    time_stamp >= '2020-01-01 00:00:00' 
    AND time_stamp < '2021-01-01 00:00:00'
GROUP BY 
    user_id;