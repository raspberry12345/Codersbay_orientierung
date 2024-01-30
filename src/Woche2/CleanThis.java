package Woche2;

public class CleanThis {


    public static void main(String[] args) {

        int age = 16;
        boolean withAdult = false;
        boolean vip = true;
        boolean access = true;

        if (age < 4) {
            System.out.println("Kein Eintritt");
            access = false;
        } else {
            if ( age <= 15 && withAdult) {
                System.out.println("Rotes Band");
            } else if (age >= 18) {
                System.out.println("Grünes Band");

            } else if (age >= 16) {
                System.out.println("Gelbes Band");
            }else{
                System.out.println("Kein Eintritt");
                access = false;
            }
            if (vip && access){
                System.out.println("Goldenes Band");
            }
        }
    }
}