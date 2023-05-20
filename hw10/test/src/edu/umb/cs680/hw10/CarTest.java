package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static List<Double> normalizeValues(List<Integer> values) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int value : values) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }

        List<Double> normalizedValues = new ArrayList<>();
        for (int value : values) {
            double normalizedValue = (double) (value - minValue) / (maxValue - minValue);
            normalizedValues.add(normalizedValue);
        }

        return normalizedValues;
    }

    @Test
    void testDM() {
        List<List<Double>> points=new ArrayList<>();
        Car c1 = new Car("a", "x", 2012, 2000, 15);
        Car c2 = new Car("b", "y", 2011, 3000, 16);
        Car c3 = new Car("c", "z", 2010, 1000, 10);
        Car c4 = new Car("d", "u", 2015, 5000, 12);
        Car c5 = new Car("e", "v", 2013, 4000, 9);
        List<Integer> car1= Arrays.asList(c1.getYear(),(int)c1.getPrice(),c1.getMileage());
        List<Integer> car2=Arrays.asList(c2.getYear(),(int)c2.getPrice(),c2.getMileage());
        List<Integer> car3=Arrays.asList(c3.getYear(),(int)c3.getPrice(),c3.getMileage());
        List<Integer> car4=Arrays.asList(c4.getYear(),(int)c4.getPrice(),c4.getMileage());
        List<Integer> car5=Arrays.asList(c5.getYear(),(int)c5.getPrice(),c5.getMileage());
        points.add(normalizeValues(car1));
        points.add(normalizeValues(car2));
        points.add(normalizeValues(car3));
        points.add(normalizeValues(car4));
        points.add(normalizeValues(car5));
        List<List<Double>> euclideanmatrix=Distance.matrix(points);
        //System.out.println(euclideanmatrix);
        List<List<Double>> ex1= List.of(
                List.of(0.0, 0.3314887845771794, 0.4989909864797196, 0.5984664150629454, 0.49790646935495286),
                List.of(0.3314887845771794, 0.0, 0.604047768025815, 0.26700193063889527, 0.166435891614040380),
                List.of(0.4989909864797196, 0.604047768025815, 0.0, 0.783039553097292, 0.7091542455503088),
                List.of(0.5984664150629454, 0.26700193063889527, 0.783039553097292, 0.0, 0.10056603902485489),
                List.of(0.49790646935495286, 0.16643589161404038, 0.7091542455503088, 0.10056603902485489, 0.0));
        assertEquals(ex1,euclideanmatrix);
        List<List<Double>> manhattanmatrix=Distance.matrix(points,new Manhattan());
        List<List<Double>> ex2= List.of(
                List.of(0.0, 0.3374433298741678, 0.4989909864797196, 0.604445260513063, 0.5038792214882082),
                List.of(0.3374433298741678, 0.0, 0.8364343163538874, 0.26700193063889527, 0.16643589161404038),
                List.of(0.4989909864797196, 0.8364343163538874, 0.0, 1.1034362469927825, 1.002870207967928),
                List.of(0.604445260513063, 0.26700193063889527, 1.1034362469927825, 0.0, 0.10056603902485489),
                List.of(0.5038792214882082, 0.16643589161404038, 1.002870207967928, 0.10056603902485489, 0.0));
        assertEquals(ex2,manhattanmatrix);
        //System.out.println(manhattanmatrix);
        List<List<Double>> cosinematrix=Distance.matrix(points,new Cosine());
        List<List<Double>> ex3= List.of(
                List.of(1.0, 1.0, 1.0, 1.0, 1.0),
                List.of(1.0, 1.0, 1.0, 1.0, 1.0),
                List.of(1.0, 1.0, 1.0, 1.0, 1.0),
                List.of(1.0, 1.0, 1.0, 1.0, 1.0),
                List.of(1.0, 1.0, 1.0, 1.0, 1.0));
        assertEquals(ex3,cosinematrix);

        //System.out.println(cosinematrix);


    }
}