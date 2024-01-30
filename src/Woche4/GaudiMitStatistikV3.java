package Woche4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GaudiMitStatistikV3 {
    public static void main(String[] args) {
        final int ARRAYSIZE = 50;
        int[] randomNumbers = new int[ARRAYSIZE];

        boolean unsorted = true;
        int success = 0;
        int next = 0;
        double average =0;
        int median=0;

        for (int i = 0; i < randomNumbers.length; i++) {
            Random r = new Random();
            randomNumbers[i] = r.nextInt(100 - 0);


        }
        System.out.println("Urliste:");
        System.out.println(java.util.Arrays.toString(randomNumbers));


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
        System.out.println("Aufsteigend sortiert:");
        System.out.println(java.util.Arrays.toString(randomNumbers));
        //----------------------------------------------------------
        // Gaudi mit StatistikV3
        //----------------------------------------------------------
        for (int i=0; i<randomNumbers.length; i++){
           average = average + randomNumbers[i];
        }
        average= average/randomNumbers.length;

        System.out.println("Arithmetisches Mittel: "+average);
        System.out.println("Spannweite: "+(randomNumbers[randomNumbers.length-1]-randomNumbers[0]));

        //----------------------------------------------------------
        // Berechnung Median
        // if -> gerade zahl / else -> ungerade zahl

        if ((randomNumbers.length)%2==0){
            median = (randomNumbers[(randomNumbers.length/2)-1]+randomNumbers[randomNumbers.length/2])/2;
            System.out.println("Median: "+ median);
        }else{
            int countLeft=0;
            int countRight=randomNumbers.length;

            do {
                countLeft++;
                countRight--;
            }while(countLeft != countRight);
            median = countLeft;
            System.out.println("Median: "+ randomNumbers[median]);
        }
        //----------------------------------------------------------
        // Berechnung Modalwert
        //
        boolean access = true;
        List<Integer> howMany = new ArrayList<Integer>();
        int mostInUse=0;
        int level =0;
        int countCheckNumber=-1;
        int result=0;
        while(access){
            howMany.clear();
            countCheckNumber++;
            for (int i=0; i<randomNumbers.length; i++){

                //System.out.println(randomNumbers[countCheckNumber]+" "+randomNumbers[i]);
                if (randomNumbers[countCheckNumber] == randomNumbers[i]){
                    howMany.add(randomNumbers[countCheckNumber]);


                }
            }

            mostInUse = howMany.size();


            if (mostInUse>level){
                level = mostInUse;
                result = randomNumbers[countCheckNumber];


            }
            if (countCheckNumber == randomNumbers.length-1){
                access = false;
            }
        }


        System.out.println("Modalwert:"+result);

        //Mittlere absolute Abweichung
        List<Double> absolutMissingNumbers = new ArrayList<Double>();
        double betweenAnswer=0;

        for (int i=0;i<randomNumbers.length; i++){

            betweenAnswer = average-randomNumbers[i];
            if (betweenAnswer < 0){
                betweenAnswer= betweenAnswer*(-1);
            }
           absolutMissingNumbers.add(betweenAnswer);
        }
        //arithmetisches Mittel



        double sum =0;
        for (int i=0; i<randomNumbers.length; i++){
            sum = sum + absolutMissingNumbers.get(i);
        }
        double meanAbsoluteDeviation = sum/randomNumbers.length;
        System.out.println(String.format("Mittlere absolute Abweichung: %.2f",meanAbsoluteDeviation));

    }
}
