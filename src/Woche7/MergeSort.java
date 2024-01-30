package Woche7;

import java.io.OptionalDataException;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {


    public static int[] divide(int[] unsorted){
        if(unsorted.length <= 1){
            return unsorted;
        }

        // deklaration und initialisierung 2arrays
        // zweigeteilte länge in den arrays und aufrunden, abrunden damit ungerade anzahl an elementen in unsorted in zwei verschiedene längen aufteilt
        int[] left = new int[(int) Math.floor(unsorted.length/2)];
        int[] right = new int[(int) Math.ceil(unsorted.length/2)];

        //befüllen der getrennten arrays links und rechts

        //links
        int leftBorder = (int) Math.floor(unsorted.length/2);
        int rightBorder = (int) Math.ceil(unsorted.length/2);
        int i=0;

        while(i< leftBorder){
            left[i] = unsorted[i];
            i++;
        }

        //rechts
        int j=0;
        while(j< rightBorder){
            right[j] = unsorted[rightBorder+j];
            j++;
        }

        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(left));
        //die zwei geteilten arrays wieder aufteilen und return der arrays


        //sortiertes array wird durch übergabe der getrennten teil-arrays über die methode conquer zusammengeführt
        return conquer(divide(left), divide(right));
    }

    public static int[] conquer(int[] left, int[] right){
        //int mergeLength = left.length+right.length;
        int mergeLength = 10;
        int[] merge = new int[mergeLength];
        int countLeft =0;
        int countRight =0;
        int countMerge =0;


            //vergleich linkes-array mit dem rechten-array, wenn kleiner dann schreibe kleineren wert in merge-array
            while(countLeft <left.length && countRight < right.length){

                while(countRight < right.length){
                    if (left[countLeft] <= right[countRight]){
                        merge[countMerge] = left[countLeft];
                        //System.out.println(left[countLeft]);

                    }else{
                        merge[countMerge] = right[countRight];
                        //System.out.println(right[countRight]);

                    }
                    countRight++;
                    countMerge++;
                }
                countLeft++;
            }
            return merge;
    }

    public static void main(String[] args) {
        final int ARRAYSIZE = 10;

        int[] unsorted = new int[ARRAYSIZE];


        //random befüllen vom array
        for (int i = 0; i < unsorted.length; i++) {
            Random r = new Random();
            unsorted[i] = r.nextInt(101);
        }
        System.out.println("Nicht sortiert");
        System.out.println(Arrays.toString(unsorted));
        System.out.println(" ");
        System.out.println("sortiert");
        System.out.println(Arrays.toString(divide(unsorted)));
    }
}
