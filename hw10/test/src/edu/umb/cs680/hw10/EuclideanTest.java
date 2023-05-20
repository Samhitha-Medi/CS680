package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanTest {
    List<Double>p1=List.of(5.0,7.0);
    List<Double>p2=List.of(2.0,3.0);
    List<List<Double>> points = List.of(p1,p2);

    @Test
    void testED()
    {
        Double actual= Distance.get(p1,p2);
        Double expected=5.0;
        assertEquals(expected,actual);
    }

    @Test
    void testEM(){
        List<List<Double>> ac=Distance.matrix(points);
        List<List<Double>> ex= List.of(
                List.of(0.0,5.0),
                List.of(5.0,0.0));
    assertEquals(ex,ac);

    }



}