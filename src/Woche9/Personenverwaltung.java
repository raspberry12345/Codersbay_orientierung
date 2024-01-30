package Woche9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Personenverwaltung {
    private List<Person> personenList = new ArrayList<Person>();
    private String name;
    public Personenverwaltung(String name){
        this.name = name;
    }
    public void createPerson(String name, String surname) {
        personenList.add(new Person(name, surname));

        System.out.println("add Person");
    }

    public void createPerson(String name, String surname, String birthdate, Adress adress, Gender gender) {
        personenList.add(new Person(name, surname, birthdate, adress, gender));
    }



    public void createPerson(String name, String surname, Gender gender, String birthdate) {
        personenList.add(new Person(name, surname, gender, birthdate));
    }


    public void deletePerson(String name){
        for (Iterator<Person> it = personenList.iterator(); it.hasNext();){
            Person p = it.next();
            if (p.name.equals(name)){
                it.remove();
                System.out.println("delete Person");
            }
        }
    }

    public void getPrintAllPerson(){
        for (Iterator<Person> it = personenList.iterator(); it.hasNext();){
            Person p = it.next();
            System.out.println(p);
        }
    }
}
