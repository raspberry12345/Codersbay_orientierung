package Woche2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KinoVerwaltungV1_1 {

    public static void main(String[] args) {
        int wallet;
        int choosenMovie = 1;
        boolean access = true;

        int amountTickets = 0;
        Scanner sc = new Scanner(System.in);

        String[][] printMovies = {{"1.", "Batman", "20:15", "1", "4"}, {"2.", "Matrix", "22:00", "3", "3"}, {"3.", "Matrix 2", "17:00", "2", "0"}};

        List<Integer> tickets = new ArrayList<Integer>();







        //--------------------------------------------------------------
        // Eingabe Geldbetrag
        System.out.println("Wieviel Geld haben Sie dabei?");
        wallet = sc.nextInt();
        //--------------------------------------------------------------


        //--------------------------------------------------------------
        // Check negative wallet
        if (wallet ==0 || wallet <0){
            access = false;
        }
        //--------------------------------------------------------------

        while (access) {






            // Output------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println(String.format("%-1s %-7s %10s %-5s %-5s", "Filmnr", "Filmname", "Uhrzeit", "Saal", "Restplätze"));
            System.out.println("-----------------------------------------------");
            for (int i = 0; i < printMovies.length; i++) {
                String available = printMovies[i][4].equals("0")?"ausgebucht":"verfügbar";
                System.out.println(String.format("%-7s %-10s %6s %4s %12s", printMovies[i][0], printMovies[i][1], printMovies[i][2], printMovies[i][3], available));


            }
            System.out.println("-----------------------------------------------");
            // Output------------------------------------------------------------------------------------------------------------------------------------------


            //--------------------------------------------------------------
            // Auswahl des gewünschten Films 1,2 oder 3
            System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
            choosenMovie = sc.nextInt();
            //--------------------------------------------------------------

            //--------------------------------------------------------------
            // Check auswahl
            // fall 1 taste input = >anzahl filme/<0 -> Hinweis
            // fall 2 taste input ist 1 bis anzahl der filme -> else normaler programmfluss

            if (choosenMovie > printMovies.length || choosenMovie < 0) {
                System.out.println("Wähle einen vorhandenen Film!");
            } else if (choosenMovie == 0) {
                access = false;
                System.out.println("Abbruch");
            } else {

                //--------------------------------------------------------------
                // Check genügend sitzplätze
                if (Integer.parseInt(printMovies[choosenMovie-1][4]) != 0 ) {
                    System.out.println("Es sind noch " + Integer.parseInt(printMovies[choosenMovie-1][4]) + " Tickets um jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen?");
                    amountTickets = sc.nextInt();





                    //--------------------------------------------------------------
                    // Check genug geld und genug tickets
                    if ((wallet-amountTickets*15)<0) {
                        System.out.println("Du hast kein Geld mehr");

                    } else if (amountTickets > Integer.parseInt(printMovies[choosenMovie-1][4])) {
                        System.out.println("Du hast zuviele Tickets gebucht");
                    }else {

                        //--------------------------------------------------------------
                        // update liste
                        for (int j = 0; j< amountTickets;j++) {
                            tickets.add(choosenMovie);
                        }
                        //--------------------------------------------------------------

                        //--------------------------------------------------------------
                        // Bestimmung von aktuell verfügbaren tickets nach dem gewählten film
                        wallet = wallet - amountTickets * 15;
                        System.out.println("Du kaufst " + amountTickets + " Tickets um " + amountTickets * 15 + "€ und hast jetzt noch " + wallet + "€");
                        //--------------------------------------------------------------


                        //--------------------------------------------------------------
                        // Update 2dim-array restplätze
                        printMovies[choosenMovie-1][4] =  String.valueOf(Integer.parseInt(printMovies[choosenMovie-1][4]) - amountTickets);
                        //--------------------------------------------------------------



                    }
                } else {

                    System.out.println("Keine Tickets mehr verfügbar");


                }

            }
        }
    }
}
