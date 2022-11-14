package _6_PokemonTrainer1;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input;

        while (!"Tournament".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s+");
            String nameTrainer = tokens[0];
            trainers.putIfAbsent(tokens[0], new Trainer(nameTrainer));

            Trainer trainer = trainers.get(nameTrainer);
            String namePokemon = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            trainer.addPokemon(new Pokemon(namePokemon, element, health));
        }

        while (!"End".equals(input = scan.nextLine())) {
            String element = input;
            trainers.values()
                    .forEach(t -> t.applyCommand(element));
        }
        trainers.values()
                .stream()
                .sorted(Comparator.comparing(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
}
