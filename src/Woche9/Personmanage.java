package Woche9;

public class Personmanage {
    public static void main(String[] args) {
        Personenverwaltung pvLinz = new Personenverwaltung("Linz");
        //Personenverwaltung coders_bay = new Personenverwaltung();
        pvLinz.createPerson("hans","wurst");
        pvLinz.createPerson("peter","mustermann");
        pvLinz.getPrintAllPerson();
        pvLinz.createPerson("Alexander", "Seebacher", "31.10.1985", new Adress("4020","linz", "Noßbergerstr","49"), Gender.MALE);
        pvLinz.deletePerson("hans");
        pvLinz.getPrintAllPerson();

    }
}
