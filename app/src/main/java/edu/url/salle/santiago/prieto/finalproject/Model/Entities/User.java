package edu.url.salle.santiago.prieto.finalproject.Model.Entities;

import java.util.ArrayList;

public class User {
    private String name;
    private long money;
    private ArrayList<String> team;
    private ArrayList<Pokeball.PokeballType> pokeballs;
    private int pokeballAm;
    private int superballAm;
    private int ultraballAm;
    private int masterballAm;

    public User(String name, long money, ArrayList<String> team, ArrayList<Pokeball.PokeballType> pokeballs, int pokeballAm, int superballAm, int ultraballAm, int masterballAm) {
        this.name = name;
        this.money = money;
        this.team = team;
        this.pokeballs = pokeballs;
        this.pokeballAm = pokeballAm;
        this.superballAm = superballAm;
        this.ultraballAm = ultraballAm;
        this.masterballAm = masterballAm;
    }
    public void addBall(Pokeball.PokeballType type){
        switch (type) {
            case POKEBALL:
                this.pokeballAm++;
            case SUPERBALL:
                this.superballAm++;
            case ULTRABALL:
                this.ultraballAm++;
            case MASTERBALL:
                this.masterballAm++;
        }

    }

    public boolean removePokemon(String pokemon){
        int i = 0;
        for (String member : team){
            if(member.equals(pokemon)){
                team.remove(member);
                pokeballs.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }


    public String getName() {
        return name;
    }
    public long getMoney(){
        return money;
    }

    public int getPokeballAm() {
        return pokeballAm;
    }

    public int getSuperballAm() {
        return superballAm;
    }

    public int getUltraballAm() {
        return ultraballAm;
    }

    public int getMasterballAm() {
        return masterballAm;
    }

    public ArrayList<String> getTeam() {
        return team;
    }

    public ArrayList<Pokeball.PokeballType> getPokeballs() {
        return pokeballs;
    }


    public void addPokemon(String pokemon, Pokeball.PokeballType type){
        team.add(pokemon);
        pokeballs.add(type);
    }
}
