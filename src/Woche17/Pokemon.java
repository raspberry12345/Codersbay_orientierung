package Woche17;

public class Pokemon {
    private int id;
    private String name;
    private String type1;
    private String type2;
    private int total;
    private int hp;
    private int attack;
    private int defense;
    private int speed;


    public Pokemon(int id, String name, String type1, String type2, int total, int hp, int attack, int defense, int speed) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Typ: ").append(type1).append("/");
        sb.append(type2).append("\n");
        sb.append("Hp: ").append(hp).append("\n");
        sb.append("Kraft: ").append(attack).append("\n");
        sb.append("Defensive: ").append(defense).append("\n");
        sb.append("Geschwindigkeit: ").append(speed).append("\n");


        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
}
