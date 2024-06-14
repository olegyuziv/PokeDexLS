package edu.url.salle.santiago.prieto.finalproject.Controller;

import static edu.url.salle.santiago.prieto.finalproject.Controller.PokemonAdapter.pokedexV;

import android.util.Log;

import org.json.JSONObject;

import edu.url.salle.santiago.prieto.finalproject.Model.BusinessGame;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokeball;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokemon;
import edu.url.salle.santiago.prieto.finalproject.Model.PokeAPI.ObtainData;
import edu.url.salle.santiago.prieto.finalproject.View.PokedexSpecificV;

public class PokedexSpecificC {
    PokedexSpecificV pokedexSpecificV;
    ObtainData obtainData;
    private BusinessGame game;

    public PokedexSpecificC(PokedexSpecificV pokedexSpecificV){
        this.pokedexSpecificV = pokedexSpecificV;
        this.obtainData = new ObtainData(pokedexV);
    }

    public void loadData(String url) {
        // url of a specific pokemon
        obtainData.getData(url, new ObtainData.DataCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                pokedexSpecificV.showInfo(result);
            }

            @Override
            public void onError(String error) {
                Log.e("PokedexSpecificC", "Error loading data: " + error);
            }
        });
    }

    /*public capturePokemon(Pokemon pokemon, Pokeball.PokeballType type){
        float chance = 0;

        chance = Pokeball.getSuccessRate(pokemon.getType(), type);
        game.capturePokemon(pokemon.getName(),type, chance);

    }

     */
}
