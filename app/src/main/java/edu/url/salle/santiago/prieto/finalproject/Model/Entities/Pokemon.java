package edu.url.salle.santiago.prieto.finalproject.Model.Entities;

import edu.url.salle.santiago.prieto.finalproject.R;

public class Pokemon {
    private String name;
    private String imageResource;
    private int pokeballResource;

    public Pokemon(String name, String imageResource, Pokeball.PokeballType pokeballResource) {
        this.name = name;
        this.imageResource = imageResource;
        this.pokeballResource = getPokeballResource(pokeballResource);
    }

    public String getName() {
        return name;
    }

    public String getImageResource() {
        return imageResource;
    }

    public int getPokeballResource(Pokeball.PokeballType pokeballResource) {
        switch (pokeballResource){
            case POKEBALL:
                return R.drawable.poke_ball;
            case SUPERBALL:
                return R.drawable.great_ball;
            case ULTRABALL:
                return R.drawable.ultra_ball;
            default:
                return R.drawable.master_ball;
        }
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }
}
