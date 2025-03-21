package edu.umb.cs680.hw10;

import java.util.List;

public class Manhattan implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double md = 0.0;
        for(int i=0; i < p1.size(); i++) {
            md += Math.abs( p1.get(i)-p2.get(i));
        }
        return md;
    }
}
