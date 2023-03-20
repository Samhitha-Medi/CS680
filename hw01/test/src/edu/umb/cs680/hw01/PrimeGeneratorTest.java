package edu.umb.cs680.hw01;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {
    @Test
    public void check_primes(){
        PrimeGenerator pg = new PrimeGenerator(3, 26);
        boolean c;
        if(pg.isPrime(5))
        {
            c=true;
        }
        else{
            c=false;
        }
        assertTrue(c);
    }
    @Test
    public void check_even(){
        PrimeGenerator pg = new PrimeGenerator(3, 26);
        boolean c;
        if(pg.isEven(8))
        {
            c=true;
        }
        else{
            c=false;
        }
        assertTrue(c);
    }

    @Test
    public void PrimeGeneratorSuccessTest() {
        PrimeGenerator pg = new PrimeGenerator(3, 26);
        pg.generatePrimes();
        Long[] expectedPrimes = new Long[] { 3L,5L, 7L, 11L, 13L, 17L, 19L, 23L };
        assertArrayEquals(expectedPrimes, pg.getPrimes().toArray());
    }

    @Test
    public void NegativeRangeFailureTest() {
        long iv = -15;
        long fv = 10;
        try {
            PrimeGenerator pg = new PrimeGenerator(iv, fv);
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=" + iv + " to=" + fv, ex.getMessage());
        }
    }


    @Test
    public void InvalidRangeFailureTest() {
        long iv = 65;
        long fv = 11;
        try {
            PrimeGenerator pg = new PrimeGenerator(iv, fv);
        } catch (RuntimeException exc) {
            assertEquals("Wrong input values: from=" + iv + " to=" + fv, exc.getMessage());
        }

    }

    @Test
    public void StartFromZeroFailureTest() {
        long iv = 0;
        long fv = 22;
        try {
            PrimeGenerator pg = new PrimeGenerator(iv, fv);
        } catch (RuntimeException exc) {
            assertEquals("Wrong input values: from=" + iv + " to=" + fv, exc.getMessage());
        }
    }
}
