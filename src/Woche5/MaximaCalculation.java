package Woche5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.getNumericValue;

public class MaximaCalculation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String receiveInput;
        List<Integer> inputNumbers = new ArrayList<Integer>();
        int maxValue =0;


        System.out.println("eingabe:");



        do{
            //einlesen aus der konsole
            receiveInput = sc.next();

            // falls nicht q -> schreibe in liste
            if(receiveInput != "q"){
                inputNumbers.add(Integer.parseInt(receiveInput));
            }
        //abbruch der wiederholung bei q eingabe
        }while(!sc.hasNext("q"));

        maxValue = inputNumbers.get(0);
        for (int i=0; i<inputNumbers.size();i++) {

            if(maxValue < inputNumbers.get(i)){
                maxValue = inputNumbers.get(i);
            }

        }
        System.out.println(maxValue);
    }
}
