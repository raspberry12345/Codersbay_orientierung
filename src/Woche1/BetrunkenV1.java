package Woche1;

import java.util.Scanner;

public class BetrunkenV1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;
        boolean license;

        System.out.println("Wie alt bist du?:");
        age = sc.nextInt();

        System.out.println("Hast du deinen Führerschein dabei?:");
        license = sc.nextBoolean();

        int shots;
        int beer;

        System.out.println("Wieviele shots?:");
        shots = sc.nextInt();

        System.out.println("Wieviele Biere?:");
        beer = sc.nextInt();

        int alcohol = shots + beer;
        if (age >= 19 && license) {
            if (alcohol == 0) {
                System.out.println("Du darfst Auto fahren");
            } else if (alcohol == 2 || alcohol == 1) {
                System.out.println("Du darfst Auto fahren");
            } else if (alcohol <= 6) {
                System.out.println("Du darfst nicht Auto fahren");
            } else {
                System.out.println("Du darfst nicht Auto fahren");
            }
        } else {

            if (alcohol == 0 && license && age >= 17) {
                System.out.println("Du darfst Auto fahren");
            } else {
                System.out.println("Du darfst nicht Auto fahren");
            }
        }

    }
}
