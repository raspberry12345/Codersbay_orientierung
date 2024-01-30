package Woche8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListeSortieren {
    public static void main(String[] args) {
        final int ARRAYSIZE = 50;
        boolean unsorted = true;
        int next;
        Random r = new Random();
        List<Integer> unsortedList = new ArrayList<Integer>();

        for (int i = 0; i < ARRAYSIZE; i++) {

            unsortedList.add(r.nextInt(101));
        }
        System.out.println("unsortiert");
        System.out.println(Arrays.toString(unsortedList.toArray()));
        System.out.println("*********************************************************");
        System.out.println("sortiert");

        //bubble sort
        while (unsorted) {
            unsorted = false;
            for (int a = 0; a < ARRAYSIZE-1; a++) {
                next = unsortedList.get(a + 1);
                if (next < unsortedList.get(a)) {
                    unsortedList.set(a+1,unsortedList.get(a));
                    unsortedList.set(a, next);
                    unsorted =true;
                }
            }
        }
        System.out.println(Arrays.toString(unsortedList.toArray()));
    }
}
