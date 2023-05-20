package edu.umb.cs680.hw15;

public class QuickSort implements SortingTechnique{
    @Override
    public int[] sort(int[] a) {
        int h=(a.length);
        quicks(a,0,h-1);
       // return array;
       // return l;
        return a;
    }
    static int partition(int a[],int l,int h){
        int pt=a[h];
        int i=(l-1);
        for(int j=l;j<=h-1;j++){
            if(a[j]<pt){
                i++;
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        int temp=a[i+1];
        a[i+1]=a[h];
        a[h]=temp;
        return (i+1);
    }

    static void quicks(int a[],int l, int h){
        int p=0;
        if(l<h) {
            p = partition(a, l, h);
            quicks(a, l, p - 1);
            quicks(a, p + 1, h);
        }
    }

}
