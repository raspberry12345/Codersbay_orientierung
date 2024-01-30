package Woche6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BingoCardGenerator {


    static  void ausgabe(int[][] bingoMap){
        for (int i=0; i<5; i++){

            for (int j=0; j<5; j++){

                if (i == 2 && j == 2){
                    System.out.print("    ");

                }else{
                    System.out.printf("%4d",bingoMap[i][j]);
                }

            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {

        int[][] bingoMap = new int[5][5];
        Random b = new Random();
        int randomNumber;
        List<Integer> checkDouble = new ArrayList<Integer>();


        for (int j=0; j<5; j++){
            for (int i=0; i<5; i++){
                do {
                    randomNumber= 1+b.nextInt(15)+15*j;
                    bingoMap[i][j] = randomNumber;
                }while (checkDouble.contains(randomNumber));
                checkDouble.add(randomNumber);
            }
        }

        bingoMap[2][2] = 0;
        ausgabe(bingoMap);
    }
}
