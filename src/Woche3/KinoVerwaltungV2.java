package Woche3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KinoVerwaltungV2 {

    public static void main(String[] args) {
        double wallet;
        int choosenMovie = 1;
        boolean access = true;
        int option;
        int amountTickets = 0;
        boolean accessCinema = true;
        Scanner sc = new Scanner(System.in);

        String[][] printMovies = {{"1.", "Batman", "20:15", "1", "4"}, {"2.", "Matrix", "22:00", "3", "3"}, {"3.", "Matrix 2", "17:00", "2", "0"}};
        String[][] printSnacks = {{"1.", "Popcorn", "1.00", "3"}, {"2.", "Chips", "2.00", "3"}, {"3.", "Schokolade", "3.50", "0"}};

        List<Integer> tickets = new ArrayList<Integer>();

        List<Integer> choosenSnacks = new ArrayList<Integer>();







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

        while (accessCinema) {
            //--------------------------------------------------------------
            // options output und einlesen der gewählten option
            System.out.println("Was willst du als nächstes tun? Du hast noch " + wallet + "€");
            System.out.println("1. Tickets kaufen");
            System.out.println("2. Snacks kaufen");
            System.out.println("3. Film ansehen");
            System.out.println("4. Snacks essen");
            System.out.println("5. Beim Gewinnspiel mitmachen (kostet 5€)");
            System.out.println("6. Kino verlassen");
            option = sc.nextInt();
            //--------------------------------------------------------------


            if (option == 1) {

                while (access) {


                    // Output------------------------------------------------------------------------------------------------------------------------------------------
                    System.out.println(String.format("%-1s %-7s %10s %-5s %-5s", "Filmnr", "Filmname", "Uhrzeit", "Saal", "Restplätze"));
                    System.out.println("-----------------------------------------------");
                    for (int i = 0; i < printMovies.length; i++) {
                        String available = printMovies[i][4].equals("0") ? "ausgebucht" : "verfügbar";
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
                        if (Integer.parseInt(printMovies[choosenMovie - 1][4]) != 0) {
                            System.out.println("Es sind noch " + Integer.parseInt(printMovies[choosenMovie - 1][4]) + " Tickets um jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen?");
                            amountTickets = sc.nextInt();

                            if (amountTickets < 0) {
                                amountTickets = amountTickets * (-1);
                            }


                            //--------------------------------------------------------------
                            // Check genug geld und genug tickets
                            if ((wallet - amountTickets * 15) < 0) {
                                System.out.println("Du hast kein Geld mehr");

                            } else if (amountTickets > Integer.parseInt(printMovies[choosenMovie - 1][4])) {
                                System.out.println("Du hast zuviele Tickets gebucht");
                            } else {

                                //--------------------------------------------------------------
                                // update liste
                                for (int j = 0; j < amountTickets; j++) {
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
                                printMovies[choosenMovie - 1][4] = String.valueOf(Integer.parseInt(printMovies[choosenMovie - 1][4]) - amountTickets);
                                //--------------------------------------------------------------


                            }
                        } else {

                            System.out.println("Keine Tickets mehr verfügbar");


                        }

                    }
                }


                //option =1 ende
            } else if (option == 2) {
                // Snack kaufen





                // Output Snacks------------------------------------------------------------------------------------------------------------------------------------------
                System.out.println(String.format("%-1s %-7s %10s %-5s", "nr", "Snack", "Preis", "Auf Lager?"));
                System.out.println("-----------------------------------------------");
                for (int i = 0; i < printSnacks.length; i++) {
                    String availableSnack = printSnacks[i][3].equals("0") ? "ausverkauft" : "auf Lager";
                    System.out.println(String.format("%-2s %-10s %7s %5s", printSnacks[i][0], printSnacks[i][1], printSnacks[i][2], availableSnack));


                }
                System.out.println("-----------------------------------------------");
                // Output Snacks------------------------------------------------------------------------------------------------------------------------------------------

                System.out.println("Welchen (noch vorhandenen) Snack möchtest du kaufen? (0 zum abbrechen)");
                int choosenSnack = sc.nextInt();

                if (choosenSnack > 0 && choosenSnack < printSnacks.length){
                    System.out.println("Es sind noch "+printSnacks[choosenSnack-1][3]+" "+printSnacks[choosenSnack-1][1]+" um jeweils "+printSnacks[choosenSnack-1][2]+"€ verfügbar. Wie viele möchtest du kaufen?");
                    int howMany = sc.nextInt();

                    if (wallet > howMany*Integer.parseInt(printSnacks[choosenSnack-1][3])){
                        if (howMany > 0 && howMany <= Integer.parseInt(printSnacks[choosenSnack-1][3])){

                            wallet = wallet - (double)howMany * Double.parseDouble(printSnacks[choosenSnack-1][2]);

                            for (int snackCounter = 0; snackCounter < howMany; snackCounter++ ){
                                choosenSnacks.add(choosenSnack);
                            }

                            System.out.println("Du kaufst "+howMany+" "+printSnacks[choosenSnack-1][1] +" um "+Double.parseDouble(printSnacks[choosenSnack-1][2])+"€ und hast jetzt noch "+wallet+"€");
                        }else{
                            System.out.println("Abbruch");
                        }
                    }else{
                        System.out.println("Not enough money!");
                    }




                }else{
                    System.out.println("Abbruch");
                }

            } else if (option == 3) {
                // Film ansehen

                //System.out.println();
                int watchingMovie;
                for(int count =0; count < tickets.size(); count++){
                    System.out.println((count+1)+". "+ printMovies[tickets.get(count)-1][1]);

                }
                System.out.println("Welchen Film (für den du noch ein Ticket hast) möchtest du sehen? (0 für abbrechen)");
                watchingMovie = sc.nextInt();
                if (watchingMovie > 0 && watchingMovie < (tickets.size()+1)){
                    int nrTicket = tickets.remove(watchingMovie-1);
                    System.out.println("Du schaust dir den Film "+printMovies[nrTicket-1][1]+ " an. Viel Spaß!");
                }else{
                    System.out.println("Abbruch");
                }


            } else if (option == 4) {
                // Snacks essen


                //System.out.println();
                int eatingSnack;
                for(int count =0; count < choosenSnacks.size(); count++){
                    System.out.println((count+1)+". "+ printSnacks[choosenSnacks.get(count)-1][1]);

                }
                System.out.println("Welchen deiner Snacks willst du essen? (0 für abbrechen)");
                eatingSnack = sc.nextInt();
                if (eatingSnack > 0 && eatingSnack < (choosenSnacks.size()+1)){
                    int nrSnack = choosenSnacks.remove(eatingSnack-1);
                    System.out.println("Du verspeist 1 "+printSnacks[nrSnack-1][1]+ ". Mjam");
                }else{
                    System.out.println("Abbruch");
                }








            } else if (option == 5) {
            // Gewinnspiel
                Random rn = new Random();
                int randomNumber = rn.nextInt(200) +1;
                int a = 1;
                int b = 1;
                int c =0;
                int win = 0;
                int winFibo =0;
                System.out.println("Deine Glückszahl ist "+ randomNumber);

                wallet = wallet -5;
                while(c < 201){
                    c= a+b;
                    System.out.println(a+"+"+b+"="+c);
                    a=b;
                    b=c;


                    //--------------------------------------------------------------
                    // check
                    // case 1 randowmNumber ist in fibo enthalten (win)


                    if (randomNumber == c){
                        win = 1;
                        winFibo = c;

                    }

                    //--------------------------------------------------------------
                }
                if (win == 1){
                    wallet = wallet + 25;
                    System.out.println(randomNumber +" ist eine Fibonacci-Nummer! Du gewinnst 20€!");
                }else{
                    System.out.println(randomNumber +" ist keine Fibonacci-Nummer! Leider nicht gewonnen");
                }


            }
            else if (option == 6) {
                System.out.println("Goodbye");
                accessCinema = false;
            } else {
                System.out.println("falsche eingabe");
            }
        }
    }
}
