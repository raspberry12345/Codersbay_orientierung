package Woche2;

import java.util.Arrays;
import java.util.Random;

public class GaudiMitArraysV1 {

    public static void main(String[] args) {

        //First In
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int [] arr2 = new int[100];
        boolean [] booleanStore = new boolean[10];


        for (int i = 0; i<100;i++){

            Random r = new Random();
            arr2[i] = r.nextInt(100-0);
            System.out.println(arr2[i]);
        }
        for (int a =0; a< booleanStore.length; a=a+2){
            booleanStore[a]=true;

        }
        System.out.println(Arrays.toString(booleanStore));
    }
}
