package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SingletonPrimeGeneratorTest {

    @Test
    void test_get_instance() {
        assertNotNull(SingletonPrimeGenerator.getInstance());
    }

    @Test
    void test_identical_instance() {
        SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance();
        SingletonPrimeGenerator instance2 = SingletonPrimeGenerator.getInstance();
        assertSame(instance1,instance2);
    }

    @Test
    void test_get_primes(){
        SingletonPrimeGenerator gen= SingletonPrimeGenerator.getInstance();
        gen.setRange(1, 10);
        Long[] expectedPrimes =  {2L, 3L, 5L, 7L};
        gen.generatePrimes();
        assertIterableEquals(Arrays.asList(expectedPrimes),gen.getPrimes());
    }

    @Test
    void test_exception(){
        long initial_value = -20;
        long final_value = 20;
        try{
            SingletonPrimeGenerator variable2 = SingletonPrimeGenerator.getInstance();
            variable2.setRange(initial_value, final_value);
        }
        catch(RuntimeException ex){
            assertEquals("Wrong input values: from=" + initial_value + " to=" + final_value,ex.getMessage());
        }
    }

    @Test
    void test_exception_2(){
        long initial_value = 20;
        long final_value = 10;
        try{
            SingletonPrimeGenerator variable2 = SingletonPrimeGenerator.getInstance();
            variable2.setRange(initial_value, final_value);
        }
        catch(RuntimeException ex){
            assertEquals("Wrong input values: from=" + initial_value + " to=" + final_value,ex.getMessage());
        }
    }

}