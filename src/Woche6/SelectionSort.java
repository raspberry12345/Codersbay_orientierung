package Woche6;

import java.util.Arrays;

public class SelectionSort {

    static void swap(int[] a, int index1, int index2){
        int temp;


        temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;

    }

    public static void main(String[] args) {



        int[] a = {64, 25, 12, 22, 11};




        int foundIndex;
        int value;

        System.out.println(Arrays.toString(a));
        for (int i=0; i<a.length; i++){

            value = a[i];
            foundIndex =0;
            for (int count=i+1; count<a.length; count++){

                //minimum

                if (value > a[count]){
                    value = a[count];
                    foundIndex = count;
                }

            }
            //austausch der werte im array
            if(foundIndex != 0) {
                swap(a, i, foundIndex);
            }
        }






        System.out.println(Arrays.toString(a));
    }
}
