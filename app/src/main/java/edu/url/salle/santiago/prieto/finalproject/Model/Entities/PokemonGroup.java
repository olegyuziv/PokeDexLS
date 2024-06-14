package edu.url.salle.santiago.prieto.finalproject.Model.Entities;

import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokemon;

public class PokemonGroup {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;

    public PokemonGroup(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public Pokemon getPokemon3() {
        return pokemon3;
    }
}
