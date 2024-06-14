package edu.url.salle.santiago.prieto.finalproject.Controller;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import edu.url.salle.santiago.prieto.finalproject.Model.PokeAPI.ObtainData;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.PokemonGroup;
import edu.url.salle.santiago.prieto.finalproject.View.PokedexV;

public class PokedexC {
    PokedexV pokedexV;
    ObtainData obtainData;

    public PokedexC(PokedexV pokedexV){
        this.pokedexV = pokedexV;
        this.obtainData = new ObtainData(pokedexV);
    }

    public void loadData(String url, PokemonAdapter pokemonAdapter) {
        obtainData.getData(url, new ObtainData.DataCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                pokemonAdapter.loadJSON(result);
                pokedexV.showInfo(pokemonAdapter);
            }

            @Override
            public void onError(String error) {
                Log.e("PokedexC", "Error loading data: " + error);
            }
        });
    }

    public void getImages(PokemonAdapter pokemonAdapter) {
        for(PokemonGroup pokemonGroup : pokemonAdapter.getPokemonGroupList()){
            obtainData.getData(pokemonGroup.getPokemon1().getImageResource(), new ObtainData.DataCallback() {
                @Override
                public void onSuccess(JSONObject result) {
                    try{
                        pokemonGroup.getPokemon1().setImageResource(result.getJSONObject("sprites").getString("front_default"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public void onError(String error) {
                    Log.e("PokedexC", "Error loading data: " + error);
                }
            });
            obtainData.getData(pokemonGroup.getPokemon2().getImageResource(), new ObtainData.DataCallback() {
                @Override
                public void onSuccess(JSONObject result) {
                    try{
                        pokemonGroup.getPokemon2().setImageResource(result.getJSONObject("sprites").getString("front_default"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public void onError(String error) {
                    Log.e("PokedexC", "Error loading data: " + error);
                }
            });
            obtainData.getData(pokemonGroup.getPokemon3().getImageResource(), new ObtainData.DataCallback() {
                @Override
                public void onSuccess(JSONObject result) {
                    try{
                        pokemonGroup.getPokemon3().setImageResource(result.getJSONObject("sprites").getString("front_default"));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public void onError(String error) {
                    Log.e("PokedexC", "Error loading data: " + error);
                }
            });
        }
    }
}
