package Woche16;

enum Gender{
    MALE,
    FEMALE
}

public class Person {
    String name;

    String surname;
    String birthdate;
    Adress adress;
    Gender gender;



    public Person(String neuerVorname, String neuerNachname, String birthdate, Adress adress, Gender gender){
        this.name= neuerVorname;
        this.surname=neuerNachname;
        this.birthdate=birthdate;
        this.adress=adress;
        this.gender= gender;

    }

    public Person(String name, String surname) {
        this.name=name;
        this.surname=surname;

    }


    public Person(String name, String surname,Gender gender, String birthdate) {
        this.name=name;
        this.surname=surname;
        this.gender=gender;
        this.birthdate=birthdate;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ");
        sb.append(surname).append(" ");
        sb.append(adress).append(" ");


        return sb.toString();
    }


}
