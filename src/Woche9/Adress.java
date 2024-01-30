package Woche9;

public class Adress {

    String zipCode;
    String location;
    String streetName;
    String doorNumber;

    public Adress(String zipCode, String location, String streetName, String doorNumber){
        this.zipCode=zipCode;
        this.location=location;
        this.streetName=streetName;
        this.doorNumber=doorNumber;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(zipCode).append(" ");
        sb.append(location).append(" ");
        sb.append(streetName).append(doorNumber);
        sb.append("\n");

        return sb.toString();
    }
}


