package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CosineTest {
    List<Double> p1=List.of(5.0,7.0);
    List<Double>p2=List.of(2.0,3.0);
    List<List<Double>> points = List.of(p1,p2);

    @Test
    void testED()
    {
        Double actual= Distance.get(p1,p2,new Cosine());
        Double expected=1.0;
        assertEquals(expected,actual);
    }

    @Test
    void testEM(){
        List<List<Double>> ac=Distance.matrix(points,new Cosine());
        List<List<Double>> ex= List.of(
                List.of(1.0,1.0),
                List.of(1.0,1.0));
        assertEquals(ex,ac);

    }


}