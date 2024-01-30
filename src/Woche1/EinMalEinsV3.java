package Woche1;

public class EinMalEinsV3 {
    public static void main(String[] args) {

        //loop prints second_number 1bis10
        for (int second_number = 1; second_number <=10; second_number++){
            //loop print first_number 1bis10
            for (int first_number = 1; first_number <=10; first_number++){
                System.out.println(first_number + "*" + second_number + "=" + (first_number * second_number));
            }
        }
    }
}
