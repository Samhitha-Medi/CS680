package edu.umb.cs680.hw15;

public class Sorting {
    //public static int[] get(int[] arr) {
       // return Sorting.get(arr,new BubbleSort());
   // }
    public static int[] get(int[] arr, SortingTechnique s){
        return s.sort(arr);
    }

    public static void main(String args[]){
        int a[]={1,4,0,2};
        int val[]=Sorting.get(a,new MergeSort());
        for(int i=0;i<a.length;i++) {
            System.out.print(val[i]);
            System.out.print(" ");
        }
    }
}


