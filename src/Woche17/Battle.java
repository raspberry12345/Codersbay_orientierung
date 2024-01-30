package Woche17;

import java.util.List;
import java.util.Scanner;

public class Battle {
    private Pokemon playerPokemon;
    private Pokemon computerPokemon;
    private List<String> attackListAsArray;
    private int random1AttackPlayer;
    private int random2AttackPlayer;
    private int random1AttackComputer;
    private int random2AttackComputer;



    public Battle(Pokemon playerPokemon, Pokemon computerPokemon, List<String> attackListAsArray) {
        //prepare
        this.playerPokemon = playerPokemon;
        this.computerPokemon = computerPokemon;
        this.attackListAsArray = attackListAsArray;
        // vergib random attacken
        int random = (int )(Math.random() * attackListAsArray.size());
        random = checkRandom(random);
        this.random1AttackPlayer = random;
        random = (int )(Math.random() * attackListAsArray.size());
        random = checkRandom(random);
        this.random2AttackPlayer = random;
        random = (int )(Math.random() * attackListAsArray.size());
        random = checkRandom(random);
        this.random1AttackComputer = random;
        random = (int )(Math.random() * attackListAsArray.size());
        random = checkRandom(random);
        this.random2AttackComputer = random;


    }
    public int checkRandom(int random){
        if (random == 0){
            random= random+1;
        }
        return random;
    }
    public void start(){
        Scanner sc = new Scanner(System.in);
        int choosenAttack;
        int choosenValueAttackPlayer = 0;
        int choosenValueAttackComputer = 0;
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        System.out.println("Spieler wählte:\n");
        System.out.println(this.playerPokemon);
        do {
            System.out.println("********************");
            System.out.println("Attacken:");
            System.out.println("1: "+convertAttackString(attackListAsArray.get(random1AttackPlayer))[1]+" "+convertAttackString(attackListAsArray.get(random1AttackPlayer))[5]);
            System.out.println("2: "+convertAttackString(attackListAsArray.get(random2AttackPlayer))[1]+" "+convertAttackString(attackListAsArray.get(random2AttackPlayer))[5]);
            System.out.println("********************");
            System.out.println("Auswahl der Attacke (1/2):");
            choosenAttack = sc.nextInt();
        }while(!(choosenAttack == 1 || choosenAttack == 2));
        if (choosenAttack ==1){
            choosenValueAttackPlayer = Integer.parseInt(convertAttackString(attackListAsArray.get(random1AttackPlayer))[5]);
        } else {
            choosenValueAttackPlayer = Integer.parseInt(convertAttackString(attackListAsArray.get(random2AttackPlayer))[5]);
        }
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        System.out.println("Computer wählte:\n");
        System.out.println(this.computerPokemon);
        System.out.println("********************");
        System.out.println("Attacken:");
        System.out.println("1: "+convertAttackString(attackListAsArray.get(random1AttackComputer))[1]+" "+convertAttackString(attackListAsArray.get(random1AttackComputer))[5]);
        System.out.println("2: "+convertAttackString(attackListAsArray.get(random2AttackComputer))[1]+" "+convertAttackString(attackListAsArray.get(random2AttackComputer))[5]);
        System.out.println("********************");
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        choosenAttack = (int )(Math.random() * 2+1);
        if (choosenAttack ==1){
            choosenValueAttackComputer = Integer.parseInt(convertAttackString(attackListAsArray.get(random1AttackComputer))[5]);
        } else if (choosenAttack == 2) {
            choosenValueAttackComputer = Integer.parseInt(convertAttackString(attackListAsArray.get(random2AttackComputer))[5]);
        }
        System.out.println("Computer wählte die Attacke: "+ choosenAttack );
        System.out.println("********************");

        if (this.playerPokemon.getSpeed()>this.computerPokemon.getSpeed()){
            System.out.println("Das Spieler-Pokemon beginnt");
            fight(this.playerPokemon,choosenValueAttackPlayer, this.computerPokemon,choosenValueAttackComputer);
        }else{
            System.out.println("Das Computer-Pokemon beginnt");
            fight(this.computerPokemon,choosenValueAttackComputer, this.playerPokemon,choosenValueAttackPlayer);
        }
    }

    public void fight(Pokemon firstPokemon, int firstPokemonAttackPower, Pokemon secondPokemon, int secondPokemonAttackPower){
        //erstes Pokemon fängt an
        int damagefirstPokemon = (int)calculateDamage(firstPokemon, firstPokemonAttackPower, secondPokemon);
        int damagesecondPokemon = (int)calculateDamage(secondPokemon, secondPokemonAttackPower, firstPokemon);
        String nameFirstPokemon = firstPokemon.getName();
        String nameSecondPokemon = secondPokemon.getName();
        System.out.println("\n");
        int count = 0;
        boolean chooseStartPokemon = true;
        do {
            count++;
            System.out.println(count+". Runde");
            if (chooseStartPokemon){

                System.out.println(nameFirstPokemon+" schlägt "+nameSecondPokemon);
                System.out.println(secondPokemon.getHp()+ " - " +damagefirstPokemon);
                secondPokemon.setHp(secondPokemon.getHp()-damagefirstPokemon);
                chooseStartPokemon = false;
            }else{

                System.out.println(nameSecondPokemon+ " schlägt " +nameFirstPokemon);
                System.out.println(firstPokemon.getHp()+ " - " +damagesecondPokemon);
                firstPokemon.setHp(firstPokemon.getHp()-damagesecondPokemon);
                chooseStartPokemon = true;
            }
            System.out.println("\n");
        }while(firstPokemon.getHp() >0 && secondPokemon.getHp()>0);
        System.out.println("\n");
        if (chooseStartPokemon){
            System.out.println(nameSecondPokemon+" gewinnt");
        }else{
            System.out.println(nameFirstPokemon+" gewinnt");
        }

    }
    public double calculateDamage(Pokemon firstPokemon, int firstPokemonAttackPower, Pokemon secondPokemon){
        return firstPokemonAttackPower*((double)firstPokemon.getAttack()/secondPokemon.getDefense())*0.04;
    }
    public String[] convertAttackString(String stringToConvert){
        String[] bufferString;
        bufferString = stringToConvert.split(";");
        return bufferString;
        }

    }

