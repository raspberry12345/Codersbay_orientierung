package Woche3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RPGV1 {


    static void outputCurrentPosition(int x, String[][] choices) {
        for(int i=0; i<choices.length;i++){
            if (x == Integer.parseInt(choices[i][1])){
                System.out.println(choices[i][2]);
            }
        }

    }

    static void showOption(int y, String[][] choices) {
        System.out.println("--------------------------------");

        for(int i=0; i<choices.length; i++){
            if(y == Integer.parseInt(choices[i][0])){
                System.out.println(choices[i][1]+" "+choices[i][2]);
            }
        }
        System.out.println("--------------------------------");
    }

    static int decision(int z, String[][] choices) {
        List<Integer> options = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int previewsZ =z;
        boolean decisionAccess = true;
        while(decisionAccess){
            //protection
            for(int i=0; i<choices.length; i++){
                if(z == Integer.parseInt(choices[i][0])){
                    options.add(Integer.parseInt(choices[i][1]));
                }
            }
            //---------------------

            System.out.println("Was willst du als nächstes tun?");
            z = sc.nextInt();

            if (!options.contains(z)){
                z = previewsZ;
                decisionAccess=true;
                //interrupt
            }else{
                decisionAccess=false;


                System.out.println(choices[z][3]);



            }




        }return z;
    }


    static int moveFurther(int a, String[][] choices) {
        int previewsNumber = a;



        // Zeilenlänge verwenden!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (choices[a].length == 5){
            return Integer.parseInt(choices[a][4]);
        }else{
            return previewsNumber;
        }



    }


    public static void main(String[] args) {
        int currentChoice =0;

        boolean access = true;

        String[][] choices = {

                // {parentID, ID, choiceTxt, resultTxt, moveToID}
                {"-1","0","Du stehst in einer Bar."},

                {"0", "1", "Gehe in die Wildniss", "Du bist in der Wildnis angekommen"},
                {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken", "0"},

                {"1", "3", "Kampf gegen das Monster", "Das Monster ist ein harter Gegner, aber du besiegst es.", "1"},
                {"1", "4", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar", "0"}};


        //start

        while(access){

            outputCurrentPosition(currentChoice, choices);
            showOption(currentChoice, choices);

            currentChoice = decision(currentChoice,choices);



            currentChoice = moveFurther(currentChoice, choices);


            //access = false;
        }




    }
}
