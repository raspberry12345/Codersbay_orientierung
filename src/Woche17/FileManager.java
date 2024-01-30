package Woche17;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<String> pokemonListAsArray = new ArrayList<>();
    private List<String> attackListAsArray = new ArrayList<>();

    public FileManager() throws IOException {
        String csvFile = "2023-03-13-Pokemon.csv";
        try (BufferedReader reader1 = new BufferedReader(new FileReader(csvFile))) {
            String currentLine = reader1.readLine();
            currentLine = reader1.readLine();
            while (currentLine != null) {
                this.pokemonListAsArray.add(currentLine);
                currentLine = reader1.readLine();
            }

            //System.out.println(pokemonListAsArray.get(0));
            csvFile = "2023-04-03-Attacks.csv";
            try (BufferedReader reader2 = new BufferedReader(new FileReader(csvFile))) {
                currentLine = reader2.readLine();
                while (currentLine != null) {
                    attackListAsArray.add(currentLine);
                    currentLine = reader2.readLine();
                }
            }
            //System.out.println(attackListAsArray.get(1));
        }

    }
    public List<String> getPokemonListAsArray() {
        return pokemonListAsArray;
    }

    public List<String> getAttackListAsArray() {
        return attackListAsArray;
    }
}
