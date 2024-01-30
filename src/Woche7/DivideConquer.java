package Woche7;

import java.util.Arrays;
import java.util.Random;

public class DivideConquer {

    public static  int max(int[] randomNumbers, int left, int right){


        if (left == right) {
            return randomNumbers[left];
        }
        int mid = (left+right)/2;
        int leftMax;
        int rightMax;

        leftMax = max(randomNumbers,left,mid);
        rightMax = max(randomNumbers,mid+1,right );

        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        final int ARRAYSIZE = 10;

        int[] randomNumbers = new int[ARRAYSIZE];


        //random befüllen vom array
        for (int i = 0; i < randomNumbers.length; i++) {
            Random r = new Random();
            randomNumbers[i] = r.nextInt(101);
        }
        System.out.println(Arrays.toString(randomNumbers));
        if(randomNumbers.length < 1){
            System.out.println("array hat zu wenig elemente");
        }else{
            System.out.println(max(randomNumbers,0,randomNumbers.length-1));
        }
    }
}
