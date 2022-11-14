package _6_PokemonTrainer1;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges = 0;
    private final List<Pokemon> pokemonCollection = new ArrayList<>();

    public Trainer(String name) {
        this.name = name;
    }

    public void addPokemon (Pokemon pokemon) {
        this.pokemonCollection.add(pokemon);
    }

    public boolean hasElement (String element ) {
        return this.pokemonCollection
                .stream()
                .anyMatch(s -> s.getElement().equals(element));
    }

    public void applyCommand (String element) {
        if (hasElement(element)) {
            this.badges++;
        } else {
            this.pokemonCollection
                    .forEach(p -> p.loose10HP());
            this.pokemonCollection
                    .removeIf(p -> p.pokemonDead());
        }
    }

    public int getBadges() {
        return this.badges;
    }

    @Override
    public String toString() {
        return name + " " + badges + " " + pokemonCollection.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
