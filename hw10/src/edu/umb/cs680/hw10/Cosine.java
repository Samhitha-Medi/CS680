package edu.umb.cs680.hw10;

import java.util.List;

public class Cosine implements DistanceMetric {
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double sum = 0.0, sum_a = 0, sum_b = 0;
        for (int i = 0; i < p1.size(); i++) {
            sum += p1.get(i) * p2.get(i);
            sum_a += p1.get(i) * p1.get(i);
            sum_b += p2.get(i) * p2.get(i);
        }
        double val = Math.sqrt(sum_a) * Math.sqrt(sum_b);

        return Math.round(sum / val);
    }
}