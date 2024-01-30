package Woche3;

import java.util.Random;

public class CyberSecurityV1 {

    public static void main(String[] args) {
        String possibleString = "ABCabc012!";
        Random rn = new Random();
        int randomNumber;
        int counter=0;
        boolean success = false;
        int countAverage =0;
        int average = 0;
        int dummyCounter =0;

        char[] possibleSigns = new char[possibleString.length()];



        //------------------------------------------------------------------
        // vom string zum char array



        while(countAverage < 5){


            for (int count=0; count<possibleSigns.length;count++){
                randomNumber = rn.nextInt(10);
                possibleSigns[count] = possibleString.charAt(randomNumber);

            }



            System.out.println("Password ist: "+possibleSigns[0]+""+possibleSigns[1]+""+possibleSigns[2]+""+possibleSigns[3]);

            for (int digitD = 0; digitD < possibleSigns.length; digitD++){
                for (int digitC =  0; digitC < possibleSigns.length; digitC++){
                    for (int digitB = 0; digitB < possibleSigns.length; digitB++){
                        for (int digitA = 0; digitA< possibleSigns.length; digitA++){
                            counter++;
                            if (possibleSigns[0] == possibleString.charAt(digitA) && possibleSigns[1] == possibleString.charAt(digitB) && possibleSigns[2] == possibleString.charAt(digitC) && possibleSigns[3] == possibleString.charAt(digitD)){
                                success = true;
                                dummyCounter = counter;

                            }

                        }
                    }
                }
            }
            counter=0;
            countAverage++;
            average= average + dummyCounter;

            if (success){
                System.out.println("Found it: "+ possibleSigns[0] +possibleSigns[1]+possibleSigns[2]+possibleSigns[3]+"=="+possibleSigns[0] +possibleSigns[1]+possibleSigns[2]+possibleSigns[3]);
                System.out.println("Took"+dummyCounter+"guesses");

            }
        }
        int durchschnitt =average/countAverage;


        System.out.println("On average took "+durchschnitt+" guesses each time");



    }



}
