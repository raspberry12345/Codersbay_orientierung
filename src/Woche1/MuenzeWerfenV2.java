package Woche1;

import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV2 {
    public static void main(String[] args) {
        int count =0;
        int zahl =0;
        int kopf =0;
        int coinflip;
        Scanner sc = new Scanner(System.in);
        System.out.println("Eingabe von gewünschten Münzwürfen:");
        coinflip = sc.nextInt();
        while(count < coinflip){
            Random r = new Random();



            if (r.nextBoolean()){
                System.out.println("Werfe Münze....Kopf");
                kopf++;
                count++;
            }else {
                System.out.println("Werfe Münze....Zahl");
                zahl++;
                count++;
            }

        }
        System.out.println("Summe Kopf: "+ kopf);
        System.out.println("Summe Zahl: "+ zahl);

    }
}
