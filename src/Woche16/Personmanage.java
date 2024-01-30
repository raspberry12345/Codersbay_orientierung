package Woche16;

import javax.naming.InvalidNameException;
import java.util.Scanner;

public class Personmanage {

    public static boolean checkInput() throws InvalidNameException{

        String input = "4353453";
        if (input.equals(":q!")){
            return true;
        }
        for(char c : input.toCharArray()){
            if (Character.isDigit(c)){

                throw new InvalidNameException("Ihre Eingabe darf keine Zahlen enthalten");
            }
        }
        return false;
    }

    public static void option1(Personenverwaltung pvLinz) {
        while(true) {
            System.out.println("Bitte geben Sie ihren Vornamen ein: /Abbruch mit :q!");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            try {
                if(checkInput()){
                    break;
                }


            } catch (InvalidNameException exception) {
                System.out.println(exception.getMessage());
                continue;
            }

            //String input = exceptionHandling();
            System.out.println("Bitte geben Sie ihren Nachnamen ein: /Abbruch mit :q!");


            String input1 = sc.nextLine();
            try {
                if(checkInput()){
                    break;
                }


            } catch (InvalidNameException exception) {
                System.out.println(exception.getMessage());
                continue;

            }


            //String input1 = exceptionHandling();
            pvLinz.createPerson(input, input1);
        }
    }

    public static void option2(Personenverwaltung pvLinz){
        while(true) {
            Scanner sc = new Scanner(System.in);
            String name;
            System.out.println("Finde eine Person gib Vor- und Nachnamen ein");
            name = sc.nextLine();
            if (name.equals(":q!")) {
                return;
            }
            String[] splittedName = name.split(" ");
            if (splittedName.length == 2) {


                try {
                    pvLinz.getUser(splittedName);
                } catch (NullPointerException exception) {
                    System.out.println(exception.getMessage());

                    //continue;
                }
            }
        }

    }


    public static void main(String[] args) throws InvalidNameException {
        Personenverwaltung pvLinz = new Personenverwaltung("Linz");
        pvLinz.createPerson("hans","wurst");
        pvLinz.createPerson("peter","mustermann");
        pvLinz.createPerson("Alexander", "Seebacher", "31.10.1985", new Adress("4020","linz", "Noßbergerstr","49"), Gender.MALE);
        Scanner sc = new Scanner(System.in);
        //menu
        while(true) {
            int option;
            System.out.println("1.Erstelle neue Person:");
            System.out.println("2.Finde Person");
            System.out.println("0.Abbruch");
            option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                option1(pvLinz);
            } else if (option == 2) {
                option2(pvLinz);

            }else if(option ==0){
                break;
            }

        }

    }
}
