// ──────────────────────────────────────────────────
// Problem  : 478. Generate Random Point in a Circle
// Difficulty: Medium
// Tags     : Math, Geometry, Rejection Sampling, Randomized
// Link     : https://leetcode.com/problems/generate-random-point-in-a-circle/
// Runtime  : 217 ms (beats 23%)
// Memory   : 56660000 (beats 78%)
// Language : java
// Copyright: (c) 2026 srinivaseswar. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.Random;

class Solution {
    private double radius;
    private double xCenter;
    private double yCenter;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        double r = radius * Math.sqrt(random.nextDouble());
        double theta = 2 * Math.PI * random.nextDouble();

        double x = xCenter + r * Math.cos(theta);
        double y = yCenter + r * Math.sin(theta);

        return new double[]{x, y};
    }
}
