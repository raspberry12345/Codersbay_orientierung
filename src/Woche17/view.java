package Woche17;

import java.util.*;
import java.io.IOException;

public class view {

    public void start() throws IOException{
        FileManager fileManger = new FileManager();
        Pokemon playerPokemon = choosePokemon(convertListToPokemonMap(fileManger.getPokemonListAsArray()));
        if (playerPokemon != null){
            Pokemon computerPokemon = randomPokemon(convertListToPokemonMap(fileManger.getPokemonListAsArray()));
            if (computerPokemon != null){
                Battle battle1 = new Battle(playerPokemon, computerPokemon, fileManger.getAttackListAsArray());
                battle1.start();
            }else{
                System.out.println("2Kein Pokemon gefunden");
            }
        }else{
            System.out.println("3Kein Pokemon gefunden");
        }
    }

    public static Map<Integer, Pokemon> convertListToPokemonMap(List<String> pokemonList){
        Map<Integer, Pokemon> pokemonMap = new HashMap<>();
        String bufferSingleLine;
        String[] bufferSingleChar;
        int count = 0;
        for (String line: pokemonList){
            count++;
            bufferSingleChar = line.split(";");
            pokemonMap.put(count, new Pokemon(Integer.parseInt(bufferSingleChar[0]),bufferSingleChar[1],bufferSingleChar[2],bufferSingleChar[3],Integer.parseInt(bufferSingleChar[4]),Integer.parseInt(bufferSingleChar[5]),Integer.parseInt(bufferSingleChar[6]),Integer.parseInt(bufferSingleChar[7]),Integer.parseInt(bufferSingleChar[10])));
        }
        /*
        for(int i=1;i<pokemonList.size();i++){
            bufferSingleLine = pokemonList.get(i);
            bufferSingleChar = bufferSingleLine.split(";");
            //System.out.println(bufferSingleChar[1]);
            pokemonMap.put(i, new Pokemon(Integer.parseInt(bufferSingleChar[0]),bufferSingleChar[1],bufferSingleChar[2],bufferSingleChar[3],Integer.parseInt(bufferSingleChar[4]),Integer.parseInt(bufferSingleChar[5]),Integer.parseInt(bufferSingleChar[6]),Integer.parseInt(bufferSingleChar[7]),Integer.parseInt(bufferSingleChar[10])));
        }
        */

        return pokemonMap;
    }

    public static Pokemon choosePokemon(Map<Integer, Pokemon> integerPokemonMap){
        Pokemon pokemon1 = null;
        Scanner sc = new Scanner(System.in);
        String input;
        boolean pokemonExist = false;

        System.out.println("Wähle ein Pokemon! Eingabe index oder Pokemonname");
        input = sc.nextLine();
        for(Pokemon pokemon : integerPokemonMap.values()){
            if (Objects.equals(input, pokemon.getName())){
                pokemonExist = true;
                pokemon1 = pokemon;
            }
        }
        /*
        for(int i=1;i< integerPokemonMap.size()+1;i++){

            if (Objects.equals(input, integerPokemonMap.get(i).getName())){
                pokemonExist = true;
                pokemon1 = integerPokemonMap.get(i);
            }
        }

         */
        if (!pokemonExist){
            //int convertedChar;
            for(char c : input.toCharArray()){
                if (Character.isDigit(c)){
                    pokemon1 = integerPokemonMap.get(Integer.parseInt(input));
                }else{
                    System.out.println("1Kein Pokemon gefunden");
                }
            }
        }
        return pokemon1;

    }

    public static Pokemon randomPokemon(Map<Integer, Pokemon> integerPokemonMap){
        int random = (int)(Math.random() * integerPokemonMap.size() + 1);
        Pokemon pokemon1;
        pokemon1 = integerPokemonMap.get(random);
        return pokemon1;
    }

}
