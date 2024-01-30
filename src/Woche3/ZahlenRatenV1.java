import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ZahlenRatenV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lastHint = "";
        boolean access = true;
        int level = 0;
        int guesses = 9;
        String[] previewsCases = new String[9];
        int counterCases=0;
        int[] tipp = new int[9];
        int upperBorder = 100;
        int lowerBorder = 0;
        int algoComputer=0;


        while(access){
            System.out.println("Welches Level möchten Sie spielen (level 1bis3)? (mit 0 können Sie abbrechen)");
            level = sc.nextInt();


            if (level ==0){
                access = false;
            } else if (level == 1) {
                boolean level1 = true;

                Random r = new Random();
                int randomNumber = r.nextInt(100);
                while(level1){

                    System.out.println("Rate eine Zahl zwischen 0 und 100");
                    int input = sc.nextInt();
                    if (input >0 && input <101){
                        if(input == randomNumber){
                            System.out.println("Du hast die Zahl erraten! Willst du weiter spielen? (ja=1 nein=0)");
                            int playAgain = sc.nextInt();
                            if (playAgain ==1) {
                                guesses = 9;
                                Random b = new Random();
                                randomNumber = b.nextInt(100);
                                System.out.println("Eine neue Runde startet!");
                            } else if (playAgain == 0) {
                                guesses =9;
                                level1 = false;
                                System.out.println("Level1 beendet!");
                            } else {
                                System.out.println("Falsche Eingabe");
                            }
                        }else if (randomNumber > input) {
                            System.out.println("Wähle eine größere Zahl!");
                            guesses--;
                        }else if (randomNumber < input) {
                            System.out.println("Wähle eine kleinere Zahl!");
                            guesses--;
                        }
                    }else{
                        System.out.println("Falsche Eingabe!");
                    }

                    if (guesses == 0){
                        level1 = false;
                        System.out.println("Verloren");
                    }

                }



            }else if (level == 2) {
                boolean accessLvl2 = true;
                Random r = new Random();
                int randomNumber = r.nextInt(100);

                while(accessLvl2){
                    System.out.println("Rate eine Zahl zwischen 0 und 100");
                    int input = sc.nextInt();



                    if (input < 101 && input >=0){



                        if (randomNumber == input) {
                            System.out.println("Du hast die Zahl erraten! Willst du weiter spielen? (ja=1 nein=0)");
                            int playAgain = sc.nextInt();
                            if (playAgain ==1) {
                                guesses =9;
                                Random b = new Random();
                                randomNumber = b.nextInt(100);
                                System.out.println("Eine neue Runde startet!");
                            } else if (playAgain == 0) {
                                guesses =9;
                                accessLvl2 = false;
                                System.out.println("Level2 beendet!");
                            }
                        } else if (input+4 >randomNumber && input-4 <randomNumber ) {
                            guesses--;
                            previewsCases[counterCases]="„fast da“: zwischen 1 und 3 daneben.";

                        } else if (input+11 >randomNumber+4 && input-11<randomNumber-4 ) {
                            guesses--;
                            previewsCases[counterCases]="„relativ nahe“: zwischen 4 und 10 daneben";

                        } else if (input+20 >=randomNumber+11 && input-20<=randomNumber-11) {
                            guesses--;
                            previewsCases[counterCases]="„Nicht ganz so weit weg“: zwischen 11 und 20 daneben";

                        } else if (input<randomNumber-20 || randomNumber+20 < input) {
                            guesses--;
                            previewsCases[counterCases]="„Weit weg“: > über 20 daneben";

                        }


                        for(int i=0; i<counterCases+1;i++){
                            System.out.println(previewsCases[i]);
                        }
                        counterCases++;

                        if (guesses == 0){
                            accessLvl2= false;
                            System.out.println("Verloren");
                        }


                    }else{
                        System.out.println("Falsche Eingabe. Versuch es nochmal!");
                    }



                }













            }else if (level == 3) {


                Random c = new Random();
                boolean randomPlayer = c.nextBoolean();
                boolean accessLvl3 = true;
                int randomNumber = c.nextInt(100);


                if (randomPlayer){
                    //Player first
                    System.out.println("Player first");
                    while(accessLvl3){


                        //Player
                        System.out.println("Wähle eine Zahl 0bis100 Abbruch=0");
                        int inputLvl3 = sc.nextInt();
                        if (inputLvl3>0&&inputLvl3<100){

                            if (randomNumber == inputLvl3) {
                                System.out.println("Du hast die Zahl erraten! Willst du weiter spielen? (ja=1 nein=0)");
                                int playAgain = sc.nextInt();
                                if (playAgain ==1) {
                                    guesses =9;
                                    Random b = new Random();
                                    randomNumber = b.nextInt(100);
                                    System.out.println("Eine neue Runde startet!");
                                } else if (playAgain == 0) {
                                    guesses =9;
                                    accessLvl3 = false;
                                    System.out.println("Level2 beendet!");
                                }
                            } else if (inputLvl3 > randomNumber) {
                                guesses--;
                                previewsCases[counterCases]="gesuchte Zahl ist kleiner";

                            } else if (inputLvl3 < randomNumber) {
                                guesses--;
                                previewsCases[counterCases] = "gesuchte Zahl ist größer";

                            }
                            tipp[counterCases]= inputLvl3;

                            System.out.println("grenzen output");
                            System.out.println(lowerBorder+" - "+upperBorder);
                            //--------------------------------------
                            //Output > <
                            for(int i=0; i<counterCases+1;i++){
                                System.out.println(previewsCases[i]);
                            }
                            //--------------------------------------

                            //--------------------------------------
                            //Output gewählten versuche
                            for(int i=0; i<counterCases+1;i++){
                                System.out.println(tipp[i]);
                            }
                            //--------------------------------------


                            counterCases++;

                            //--------------------------------------
                            //Output
                            if (guesses == 0){
                                accessLvl3= false;
                                System.out.println("Verloren");
                            }
                            //--------------------------------------

                            //--------------------------------------
                            //Berechnung der Grenzen für computer

                            lastHint = previewsCases[counterCases-1];
                            int dummy = tipp[counterCases-1];
                            if (lastHint.equals("gesuchte Zahl ist kleiner") ){

                                upperBorder = dummy-1;
                                tipp[counterCases] = ((upperBorder-lowerBorder)/2)+lowerBorder;

                            }else{

                                lowerBorder = dummy+1;
                                tipp[counterCases] = ((upperBorder-lowerBorder)/2)+lowerBorder;

                            }


                            //--------------------------------------
                            //Computer
                            System.out.println("Computer wählt");
                            if (randomNumber == tipp[counterCases]) {

                                System.out.println("Der Computer gewinnt");

                            } else if (tipp[counterCases] > randomNumber) {
                                guesses--;
                                previewsCases[counterCases]="gesuchte Zahl ist kleiner";

                            } else if (tipp[counterCases] < randomNumber) {
                                guesses--;
                                previewsCases[counterCases] = "gesuchte Zahl ist größer";

                            }

                            System.out.println("grenzen output");
                            System.out.println(lowerBorder+" - "+upperBorder);
                            //--------------------------------------
                            //Output > <
                            for(int i=0; i<counterCases;i++){
                                System.out.println(previewsCases[i]);
                            }
                            //--------------------------------------

                            //--------------------------------------
                            //Output gewählten versuche
                            for(int i=0; i<counterCases;i++){
                                System.out.println(tipp[i]);
                            }
                            //--------------------------------------





                            //--------------------------------------
                            //Output
                            if (guesses == 0){
                                accessLvl3= false;
                                System.out.println("Verloren");
                            }
                            //--------------------------------------



                        }else {
                            accessLvl3 = false;
                            System.out.println("Abbruch");
                        }




                        //--------------------------------------
                        //Output > <
                        for(int i=0; i<counterCases+1;i++){
                            System.out.println(previewsCases[i]);
                        }
                        //--------------------------------------

                        //--------------------------------------
                        //Output gewählten versuche
                        for(int i=0; i<counterCases+1;i++){
                            System.out.println(tipp[i]);
                        }
                        //--------------------------------------

                        counterCases++;
                    }

                }else{
                    //Computer first
                    System.out.println("Computer first");
                }





            }else{
                System.out.println("Error");
            }


        }




    }
}

