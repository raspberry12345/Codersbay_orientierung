package Woche6;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        final int ARRAYSIZE = 50;
        int[] randomNumbers = new int[ARRAYSIZE];

        boolean unsorted = true;
        int success = 0;
        int next = 0;

        for (int i = 0; i < randomNumbers.length; i++) {
            Random r = new Random();
            randomNumbers[i] = r.nextInt(100 - 0);

        }

        System.out.println("*********************************************************");


        //bubble sort
        while (unsorted) {
            unsorted = false;
            for (int a = 0; a < randomNumbers.length - 1; a++) {
                next = randomNumbers[a + 1];
                if (next < randomNumbers[a]) {
                    randomNumbers[a + 1] = randomNumbers[a];
                    randomNumbers[a] = next;
                    unsorted =true;
                }

            }



        }


        System.out.println(Arrays.toString(randomNumbers));

    }
}
