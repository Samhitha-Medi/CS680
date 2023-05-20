package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void test_price() {
        ArrayList<Car> usedCars = new ArrayList<Car>();
        usedCars.add(new Car("honda", "smodel", 2022, 20000, 15));
        usedCars.add(new Car("mahindra", "suv", 2023, 30000, 19));
        Collections.sort(usedCars, new PriceComparator());
        String expected="mahindra";
        assertArrayEquals(expected.toCharArray(), usedCars.get(1).getMake().toCharArray());
    }

    @Test
    public void test_year() {
        ArrayList<Car> ucs = new ArrayList<Car>();
        ucs.add(new Car("honda", "smodel", 2022, 20000, 15));
        ucs.add(new Car("mahindra", "suv", 2023, 30000, 19));
        Collections.sort(ucs, new YearComparator());
        String exp="honda";
        assertArrayEquals(exp.toCharArray(), ucs.get(1).getMake().toCharArray());
    }
    @Test
    public void test_mileage() {
        ArrayList<Car> us = new ArrayList<Car>();
        us.add(new Car("honda", "smodel", 2022, 20000, 15));
        us.add(new Car("mahindra", "suv", 2023, 30000, 19));
        Collections.sort(us, new MileageComparator());
        String expe="mahindra";
        //System.out.println(us.get(0).getMake());
        assertArrayEquals(expe.toCharArray(), us.get(0).getMake().toCharArray());
    }
    @Test
    public void test_pareto() {
        ArrayList<Car> usd = new ArrayList<Car>();
        usd.add(new Car("mahindra", "suv", 2012, 30000, 19));
        usd.add(new Car("honda", "smodel", 2014, 20000, 15));
        usd.add(new Car("hyundai", "sedan", 2015, 30300, 9));
        usd.add(new Car("telsa","xmodel",2021,50000,20));
        for(Car car: usd){
            car.setDominationCount(usd);
        }
        Collections.sort(usd, new ParetoComparator());
        String expe="honda";
        //System.out.println(usd.get(3).getMake());
        assertArrayEquals(expe.toCharArray(), usd.get(0).getMake().toCharArray());
    }

}