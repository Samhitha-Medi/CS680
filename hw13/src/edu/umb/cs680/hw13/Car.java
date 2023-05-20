package edu.umb.cs680.hw13;

import java.util.ArrayList;

public class Car {
    private String model, make;
    private int mileage, year;
    private float price;

    int dc;



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
    public int getDominationCount(){
        return this.dc;
    }
    public void setDominationCount(ArrayList<Car> cars) {
        this.dc = 0;

        for (Car car : cars) {
            if(car.getMileage() <= this.getMileage() && car.getPrice() <= this.getPrice() && car.getYear() >= this.getYear()) {
                if(car.getMileage() < this.getMileage() || car.getPrice() < this.getPrice() || car.getYear() > this.getYear()) {
                    dc++;
                }
            }
        }
    }

    //        dc=0;
//        for(Car newcar:cars){
//            if(this!=newcar){
//                boolean a=false,b=true;
//                if(this.getMileage()>newcar.getMileage()||
//                this.getYear()> newcar.getYear()|| this.getPrice()> newcar.getPrice()){
//                    a=true;
//                }
//                else if(this.getPrice()<newcar.getPrice()||
//                        this.getYear()< newcar.getYear() ||this.getMileage()< newcar.getMileage()){
//                        b=false;
//                }
//                if(a&&b==false){
//                    dc++;
//                }
//            }
//        }
//        this.dc=dc;
//    }
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
