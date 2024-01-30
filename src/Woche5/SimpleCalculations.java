package Woche5;

public class SimpleCalculations {
    public static void main(String[] args) {
        int numberOne=50;
        int numberTwo=30;
        double resultDivison;
        resultDivison= (double) numberOne / numberTwo;
        System.out.println("Addition: "+numberOne+"+"+numberTwo+"="+ (numberOne+numberTwo));
        System.out.println("Subtraktion: "+numberOne+"-"+numberTwo+"="+ (numberOne-numberTwo));
        System.out.println("Multiplikation: "+numberOne+"*"+numberTwo+"="+ (numberOne*numberTwo));
        System.out.println("Division(geradzahlige Division): "+numberOne+"/"+numberTwo+"="+ (numberOne/numberTwo));

        System.out.println(String.format("Division(mit gleitkomma) %.2f",resultDivison));
    }
}
