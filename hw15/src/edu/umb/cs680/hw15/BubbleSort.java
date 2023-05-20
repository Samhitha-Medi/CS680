package edu.umb.cs680.hw15;

public class BubbleSort implements SortingTechnique{
    @Override
    public int[] sort(int[] array) {
        int n= array.length;
        int t=0;
        for(int i=0;i<n;i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j-1]>array[j]){
                    t=array[j-1];
                    array[j-1]=array[j];
                    array[j]=t;
                }
            }
        }
        //System.out.println(array);
        return array;
        //return n;
    }
}
