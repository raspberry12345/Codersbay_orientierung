package Woche1;

import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV4 {
    public static void main(String[] args) {
        Random r = new Random();
        int count = 0;
        int zahl = 0;
        int kopf = 0;
        int buffer = 0;
        boolean happy;

        do {

            //Einlesen der Münzwürfe und prüfen auf gültigen input
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10)?");
                buffer = sc.nextInt();

            } while ((buffer < 0 || buffer > 10) || ((count+buffer) % 2 == 0));


            count+= buffer;
            int count_loop = 0;
            Scanner object = new Scanner(System.in);


            //wiederholte Ausgabe von Münzwurfergebnissen
            while(count_loop < buffer){

                if (r.nextBoolean()){
                    System.out.println("Werfe Münze....Kopf");
                    kopf++;
                    count_loop++;
                }else {
                    System.out.println("Werfe Münze....Zahl");
                    zahl++;
                    count_loop++;
                }

            }
            //summierte Ausgabe von kopf und zahl
            System.out.println("Summe Kopf: "+kopf);
            System.out.println("Summe Zahl: "+zahl);
            //check true or false
            // if false stay in the loop
            System.out.println("Bist du mit dem Ergebnis zufrieden?");
            happy = object.nextBoolean();
            if (happy) {
                if (kopf > zahl) {
                    System.out.println("Ich bekomme das Ticket");
                } else {
                    System.out.println("Stefan bekommt das Ticket.");
                }
                happy = false;
            }else{
                happy = true;
            }


        }while(happy);
    }

}
