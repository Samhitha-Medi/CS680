package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Car {
    private String model, make;
    private int mileage, year;
    private float price;





    public String getModel()
    {
        return this.model;
    }
    public String getMake()
    {
        return this.make;
    }

    public int getYear()
    {
        return this.year;
    }
    public int getMileage()
    {
        return this.mileage;
    }
    public float getPrice()
    {
        return this.price;
    }
    public Car(String make, String model, int year,int price,int mileage) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.mileage = mileage;
        this.year = year;
    }

    public static void main(String args[])
    {
        Car c= new Car("Tesla", "S-Class", 2022, 17789, 15);
        System.out.println("Make: " + c.getMake());
        System.out.println("Model: " + c.getModel());
        System.out.println("Mileage: " + c.getMileage());
        System.out.println("Year: " + c.getYear());
        System.out.println("Price: " + c.getPrice());
    }


}
