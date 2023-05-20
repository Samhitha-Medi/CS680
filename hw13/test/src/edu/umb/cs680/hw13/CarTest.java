package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    ArrayList<Car> cl=new ArrayList<>();

    @Test
    public void test_price() {
        ArrayList<Car> usedCars = new ArrayList<Car>();
        usedCars.add(new Car("honda", "smodel", 2022, 20000, 15));
        usedCars.add(new Car("mahindra", "suv", 2023, 30000, 19));
        Collections.sort(usedCars,
                Comparator.comparing(
                        (Car car)-> car.getPrice() ));
        String expected="mahindra";
        assertArrayEquals(expected.toCharArray(), usedCars.get(1).getMake().toCharArray());
    }
    @Test
    public void test_year() {
        ArrayList<Car> ucs = new ArrayList<Car>();
        ucs.add(new Car("honda", "smodel", 2022, 20000, 15));
        ucs.add(new Car("mahindra", "suv", 2023, 30000, 19));
        Collections.sort(ucs, Comparator.comparing(
                (Car car)-> car.getYear() ));
        String exp="mahindra";
        assertArrayEquals(exp.toCharArray(), ucs.get(1).getMake().toCharArray());
    }
    @Test
    public void test_mileage() {
        ArrayList<Car> us = new ArrayList<Car>();
        us.add(new Car("honda", "smodel", 2022, 20000, 15));
        us.add(new Car("mahindra", "suv", 2023, 30000, 19));
        Collections.sort(us, Comparator.comparing(
                (Car car)-> car.getMileage() ));
        String expe="honda";
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
        Collections.sort(usd,Comparator.comparing(
                (Car car)-> car.getDominationCount() ) );
        String expe="honda";
        //System.out.println(usd.get(0).getMake());
        assertArrayEquals(expe.toCharArray(), usd.get(0).getMake().toCharArray());
    }

    @Test
    public void test_ReverseOrder(){
        cl.add(new Car("mahindra", "suv", 2012, 30000, 19));
        cl.add(new Car("honda", "smodel", 2014, 20000, 15));
        cl.add(new Car("hyundai", "sedan", 2015, 30300, 9));
        Collections.sort(cl,
                Comparator.comparing((Car::getPrice),Comparator.reverseOrder() ));
        //System.out.println(cl.get(0).getMake());
        assertEquals("hyundai",cl.get(0).getMake());
    }

}