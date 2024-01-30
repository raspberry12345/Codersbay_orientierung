package Woche5;

import java.util.Scanner;

public class ArbeitsOderFreizeit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputTime;
        String[] convertTime = new String[2];
        int hour = 0;

        System.out.println("Gib eine Uhrzeit in dem Format 8:00 ein!");
        inputTime = sc.nextLine();

        convertTime = inputTime.split(":");

        hour = 60* Integer.parseInt(convertTime[0]);
        hour += Integer.parseInt(convertTime[1]);

        if (510<=hour && hour < 720){
            System.out.println("Arbeitszeit");
        } else if (720 <= hour && hour < 750) {
            System.out.println("Mahlzeit");
        } else if (750 <= hour && hour <930) {
            System.out.println("Arbeitszeit");
        }
    }
}
