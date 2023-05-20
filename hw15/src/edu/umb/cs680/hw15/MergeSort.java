package edu.umb.cs680.hw15;

public class MergeSort implements SortingTechnique{
    void merge(int a[],int l,int m, int r){
        int x=m-l+1;
        int y=r-m;
        int L[]=new int[x];
        int R[]=new int[y];
        for(int i=0;i<x;++i)
            L[i]=a[l+i];
        for(int j=0;j<y;j++)
            R[j]=a[m+1+j];
        int i=0,j=0;
        int k=l;
        while(i<x && j<y){
            if(L[i]<=R[j]){
                a[k]=L[i];
                i++;
            }
            else{
                a[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<x){
            a[k]=L[i];
            i++;
            k++;
        }
        while(j<y){
            a[k]=R[j];
            j++;
            k++;
        }


    }
    void ms(int a[],int l,int r){
        if(l<r){
            int m=(l+r)/2;
            ms(a,l,m);
            ms(a,m+1,r);
            merge(a,l,m,r);
        }
    }
    @Override
    public int[] sort(int[] a) {
        ms(a,0,a.length-1);
       // return array;
       // return 0;
        return a;
    }
}
