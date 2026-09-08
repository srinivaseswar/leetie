-- ──────────────────────────────────────────────────
-- Problem  : 177. Nth Highest Salary
-- Difficulty: Medium
-- Tags     : Database
-- Link     : https://leetcode.com/problems/nth-highest-salary/
-- Runtime  : 608 ms (beats 17%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 srinivaseswar. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT salary
      FROM Employee
      ORDER BY salary DESC
      LIMIT 1 OFFSET M
  );
END