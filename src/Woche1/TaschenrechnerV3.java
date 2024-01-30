package Woche1;

import java.util.Scanner;

public class TaschenrechnerV3 {
    public static void main(String[] args) {


        char operator;
        int firstnumber;
        int secondnumber;
        boolean check = true;

        // check if input is the following input-signs otherwhise repeat
        while(check){
            Scanner sc = new Scanner(System.in);
            // ask for input
            System.out.println("Gib den Operator (+, -, *, /, %) ein:");
            //input
            operator = sc.nextLine().toUpperCase().charAt(0);
            //check input
            if (operator == '+' ||operator == '-' ||operator == '*' ||operator == '/' ||operator == '%' ){
                //ask for numbers and scan it
                System.out.println("Gib die erste Zahl ein:");
                firstnumber = sc.nextInt();
                System.out.println("Gib die zweite Zahl ein:");
                secondnumber = sc.nextInt();

                //calculate and print
                switch (operator){
                    case '+':
                        System.out.println(firstnumber + "+" + secondnumber + "=" + (firstnumber + secondnumber));
                        break;

                    case '-':
                        System.out.println(firstnumber + "-" + secondnumber + "=" + (firstnumber - secondnumber));
                        break;

                    case '*':
                        System.out.println(firstnumber + "*" + secondnumber + "=" + (firstnumber * secondnumber));
                        break;

                    case '%':
                        System.out.println(firstnumber + "%" + secondnumber + "=" + (firstnumber % secondnumber));
                        break;


                    case '/':
                        System.out.println(firstnumber + "/" + secondnumber + "=" + (firstnumber / secondnumber));
                        break;
                }

            } else if (operator == 'X') {
                check = false;
            }
        }
    }
}
