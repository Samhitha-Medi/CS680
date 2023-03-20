package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private String[] carToStringArray(Car car_instance)
    {
        String[] car = new String[]{car_instance.getMake(),car_instance.getModel(), String.valueOf(car_instance.getYear())};
        return car;
    }

    @Test
    void VerifyCarEqualityWithMakeModelYear()
    {
        String[] expected = new String[]{"Toyota","RAV4","2018"};
        Car actual = new Car("Toyota","RAV4",2018,180900,30);
        assertArrayEquals(expected,carToStringArray(actual));
    }

    @Test
    void test_equal_values()
    {
        Car car1 = new Car("Tesla","model-s",2020,310000,11);
        Car car2 = new Car("Tesla","model-s",2022, 166000 , 7);
        assertEquals(car1.getModel(), car2.getModel());
    }

    @Test
    void test_MAKE_values()
    {
        Car car1 = new Car("Tesla","model-s",2020,310000,11);
        Car car2 = new Car("Tesla","model-s",2022, 166000 , 7);
        assertEquals(car1.getMake(), car2.getMake());
    }
    @Test
    void test_Mileage_values()
    {
        Car car1 = new Car("Tesla","model-s",2020,310000,11);
        Car car2 = new Car("Tesla","model-s",2022, 166000 , 7);
        assertNotEquals(car1.getMileage(), car2.getMileage());
    }

}