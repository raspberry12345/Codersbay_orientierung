package Woche4;

import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV11 {

    //Methoden


    static int computerPlayer(int guess, int countRounds, int lowerBorder, int upperBorder) {


        if (countRounds == 0){
            //--------------------------------------
            //Computer first round
            System.out.println("Der Computer wählt: "+guess);
            return guess;
        }else{
            //--------------------------------------
            //humanPlayer first round

            guess = ((upperBorder-lowerBorder)/2)+lowerBorder;
            System.out.println("Der Computer wählt: "+guess);
            return guess;
        }

    }

    static int humanPlayer(int guess) {

        do {

            Scanner sc = new Scanner(System.in);
            System.out.println("Wähle eine Zahl 0 bis 100");
            guess = sc.nextInt();


        } while (guess<0||guess>100);


        return guess;
    }

    static int check(int guess, int randomNumber, String[][] valueSign, int countRounds, boolean randomPlayer) {

        valueSign[countRounds][0]= Integer.toString(guess);
        String gewinner;

        if (randomPlayer){
            gewinner = "Computer Player ";
        }else{
            gewinner = "Human Player ";
        }
        if (randomNumber == guess) {
        System.out.println(gewinner+"hat gewonnen");
        guess = -1;

        } else if (guess > randomNumber) {
            System.out.println("Die gesuchte Zahl ist kleiner");
            System.out.println(" ");
            valueSign[countRounds][1]= " kleiner";

        } else {
            System.out.println("Die gesuchte Zahl ist größer");
            System.out.println(" ");
            valueSign[countRounds][1]= " größer";
        }


        return guess;
    }

    static void output(String[][] valueSign) {


        for (int i=0; i<valueSign.length; i++){

            if (valueSign[i][0] != null){
                System.out.println(valueSign[i][0] + valueSign[i][1]);
            }
        }
        System.out.println(" ");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean access = true;
        int level;
        int guesses = 9;
        String[] previewsCases = new String[9];
        int counterCases = 0;


        while (access) {
            System.out.println("Welches Level möchten Sie spielen (level 1bis3)? (mit 0 können Sie abbrechen)");
            level = sc.nextInt();


            if (level == 0) {
                access = false;
            } else if (level == 1) {
                boolean level1 = true;

                Random r = new Random();
                int randomNumber = r.nextInt(100);
                while (level1) {

                    System.out.println("Rate eine Zahl zwischen 0 und 100");
                    int input = sc.nextInt();
                    if (input > 0 && input < 101) {
                        if (input == randomNumber) {
                            System.out.println("Du hast die Zahl erraten! Willst du weiter spielen? (ja=1 nein=0)");
                            int playAgain = sc.nextInt();
                            if (playAgain == 1) {
                                guesses = 9;
                                Random b = new Random();
                                randomNumber = b.nextInt(100);
                                System.out.println("Eine neue Runde startet!");
                            } else if (playAgain == 0) {
                                guesses = 9;
                                level1 = false;
                                System.out.println("Level1 beendet!");
                            } else {
                                System.out.println("Falsche Eingabe");
                            }
                        } else if (randomNumber > input) {
                            System.out.println("Wähle eine größere Zahl!");
                            guesses--;
                        } else  {
                            System.out.println("Wähle eine kleinere Zahl!");
                            guesses--;
                        }
                    } else {
                        System.out.println("Falsche Eingabe!");
                    }

                    if (guesses == 0) {
                        level1 = false;
                        System.out.println("Verloren");
                    }

                }


            } else if (level == 2) {
                boolean accessLvl2 = true;
                Random r = new Random();
                int randomNumber = r.nextInt(100);

                while (accessLvl2) {
                    System.out.println("Rate eine Zahl zwischen 0 und 100");
                    int input = sc.nextInt();


                    if (input < 101 && input >= 0) {

                        int diff = Math.abs(input-randomNumber);
                        if (randomNumber == input) {
                            System.out.println("Du hast die Zahl erraten! Willst du weiter spielen? (ja=1 nein=0)");
                            int playAgain = sc.nextInt();
                            if (playAgain == 1) {
                                guesses = 9;
                                Random b = new Random();
                                randomNumber = b.nextInt(100);
                                diff = Math.abs(input-randomNumber);
                                System.out.println("Eine neue Runde startet!");
                            } else if (playAgain == 0) {
                                guesses = 9;
                                accessLvl2 = false;
                                System.out.println("Level2 beendet!");
                            }

                        } else if (diff <= 3) {
                            previewsCases[counterCases] = "„fast da“: zwischen 1 und 3 daneben.";

                        } else if (diff <=10) {
                            previewsCases[counterCases] = "„relativ nahe“: zwischen 4 und 10 daneben";

                        } else if (diff <= 20) {
                            previewsCases[counterCases] = "„Nicht ganz so weit weg“: zwischen 11 und 20 daneben";

                        } else if (diff > 20) {
                            previewsCases[counterCases] = "„Weit weg“: > über 20 daneben";

                        }
                        guesses--;
                        if (!accessLvl2) {
                            for (int i = 0; i < counterCases + 1; i++) {
                                System.out.println(previewsCases[i]);
                            }
                        }
                        counterCases++;

                        if (guesses == 0) {
                            accessLvl2 = false;
                            System.out.println("Verloren");
                        }


                    } else {
                        System.out.println("Falsche Eingabe. Versuch es nochmal!");
                    }


                }


            } else if (level == 3) {
                //-------------------------
                // Fall 3
                //-------------------------



                // Variablen
                int guess = 50;
                int countRounds = 0;
                Random c = new Random();
                int randomNumber = c.nextInt(100);

                boolean accessLvl3 = true;
                int upperBorder = 100;
                int lowerBorder = 0;
                String[][] valueSign = new String[9][2];

                //create random boolean true or false
                Random a = new Random();
                boolean randomPlayer = a.nextBoolean();
                //-------------------------


                // Start LVL3
                while (accessLvl3) {




                    //choose Player
                    if (randomPlayer) { // <- insert randomPlayer
                        //humanplayer
                        guess = humanPlayer(guess);
                        randomPlayer = false;
                    } else {
                        //computerplayer
                        guess = computerPlayer(guess, countRounds, lowerBorder, upperBorder);
                        randomPlayer = true;
                    }
                    guess = check(guess, randomNumber, valueSign, countRounds, randomPlayer);

                    if (guess == -1){
                        //exit case
                        accessLvl3 = false;
                        countRounds=0;
                        System.out.println("Programmende");

                    }else{
                    // show goes on!
                        if (guess < randomNumber && guess >lowerBorder){
                            lowerBorder = guess;
                        }else if (guess > randomNumber && guess < upperBorder){
                            upperBorder = guess;
                        }
                        System.out.println("Intervall: "+lowerBorder+" bis "+upperBorder);

                        output(valueSign);




                        countRounds++;

                    }

                }


            } else {
                access = false;
                System.out.println("Abbruch");
            }


        }


    }
}


