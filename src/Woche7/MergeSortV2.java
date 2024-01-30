package Woche7;

import java.util.Arrays;
import java.util.Random;

public class MergeSortV2 {


    public static int[] divide(int[] unsorted){
        if(unsorted.length <= 1){
            return unsorted;
        }


        int[] left = Arrays.copyOfRange(unsorted, 0 , unsorted.length/2);
        int[] right = Arrays.copyOfRange(unsorted, unsorted.length/2, unsorted.length);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        //sortiertes array wird durch übergabe der getrennten teil-arrays über die methode conquer zusammengeführt
        return conquer(divide(left), divide(right));
    }

    public static int[] conquer(int[] left, int[] right){
        int mergeLength = left.length+right.length;
        int[] merge = new int[mergeLength];
        int countLeft =0;
        int countRight =0;
        int countMerge =0;
        System.out.println("linke:"+Arrays.toString(left));
        System.out.println("rechts:"+Arrays.toString(right));
        //vergleich linkes-array mit dem rechten-array, wenn kleiner dann schreibe kleineren wert in merge-array
        while(countLeft <left.length && countRight < right.length){


            if (left[countLeft] <= right[countRight]){

                    merge[countMerge] = left[countLeft];

                    countLeft++;
            }else{

                    merge[countMerge] = right[countRight];

                    countRight++;

            }
            countMerge++;


        }
        while(countLeft<left.length){
            merge[countMerge++] = left[countLeft++];
        }
        while(countRight<right.length){
            merge[countMerge++] = right[countRight++];
        }
        return merge;
    }

    public static void main(String[] args) {
        final int ARRAYSIZE = 10;
        Random r = new Random();
        int[] unsorted = new int[ARRAYSIZE];

        //random befüllen vom array
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = r.nextInt(101);
        }
        System.out.println("Nicht sortiert");
        System.out.println(Arrays.toString(unsorted));
        System.out.println(" ");
        System.out.println("sortiert");
        System.out.println(Arrays.toString(divide(unsorted)));
    }
}
