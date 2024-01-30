package Woche5;

import java.util.Random;
import java.util.Scanner;

public class CaesarChiffre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message;
        int offset = -5;
        String encodedMessage = "";
        Random b = new Random();
        offset = b.nextInt(26);


        System.out.println(offset);

        System.out.println("Gib eine zu verschlüsselnde Nachricht ein!");
        message = sc.nextLine();

        for ( char c : message.toCharArray()){

            if ('A' <= c && c <= 'Z'){
                c= (char) (c+offset);
                if (c > 'Z'){
                    c = (char) (c-26);
                }


            } else if ('a'<= c && c<='z') {
                c= (char) (c+offset);
                if (c > 'z'){
                    c = (char) (c-26);
                }

            }
            encodedMessage += c;
        }
        System.out.println(message);
        System.out.println(encodedMessage);

    }
}
