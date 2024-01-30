package Woche6;

import java.util.Arrays;

public class Insertionsort {


    public static void main(String[] args) {

        int[] array = {5, 2, 4, 6, 1,3};
        int toInsert;
        int j;


        System.out.println(Arrays.toString(array));
        for (int i=1; i<array.length; i++){
            toInsert = array[i];
            j = i;

            while((j > 0) && (array[j-1] > toInsert)){
                array[j] = array[j-1];
                j--;
            }
            array[j] = toInsert;
        }



        System.out.println(" ");


        System.out.println(Arrays.toString(array));

    }
}
