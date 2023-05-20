package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    public void test_BubbleSort(){
        int array[]={2,0,1};;
        int ac[]=Sorting.get(array,new BubbleSort());
        //System.out.println(ac[0]);
        assertEquals(2,ac[2]);
    }
    @Test
    public void test_QuickSort(){
        int array[]={2,0,1};
        int ac[]=Sorting.get(array,new QuickSort());
        //System.out.println(ac[0]);
        assertEquals(0,ac[0]);
    }

    @Test
    public void test_MergeSort(){
        int array[]={2,0,1};;
        int ac[]=Sorting.get(array,new MergeSort());
        //System.out.println(ac[0]);
        assertEquals(1,ac[1]);
    }


}