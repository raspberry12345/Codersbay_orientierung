package Woche1;

import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV3 {
    public static void main(String[] args) {
        boolean key = true;
        int count = 0;
        int zahl = 0;
        int kopf = 0;

        //loop scan input and repeat if its no valid input
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10)?");
            count = sc.nextInt();

        } while ((count < 0 || count > 10) || (count % 2 == 0));

        int count_loop = 0;

        //print the single resault of the coinflip
        while(count_loop < count){
            Random r = new Random();

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
        //print sum from kopf and zahl
        System.out.println("Summe Kopf: "+kopf);
        System.out.println("Summe Zahl: "+zahl);

        //print who wins the ticket
        if(kopf > zahl){
            System.out.println("Ich bekomme das Ticket");
        }else{
            System.out.println("Stefan bekommt das Ticket.");
        }
    }


}

