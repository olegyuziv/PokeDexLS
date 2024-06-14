package edu.url.salle.santiago.prieto.finalproject.Controller;

import android.util.Log;

import org.json.JSONObject;

import edu.url.salle.santiago.prieto.finalproject.Model.BusinessGame;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokeball;
import edu.url.salle.santiago.prieto.finalproject.Model.PokeAPI.ObtainData;
import edu.url.salle.santiago.prieto.finalproject.View.StoreV;
import edu.url.salle.santiago.prieto.finalproject.View.TrainerV;

public class TrainerC {
    private TrainerV trainerV;
    private ObtainData obtainData;

    private BusinessGame game;

    public TrainerC(TrainerV trainerV){
        this.trainerV = trainerV;
        this.obtainData = new ObtainData(trainerV);
    }

    public void loadData(String url) {
        // url of a specific pokemon
        obtainData.getData(url, new ObtainData.DataCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                trainerV.showInfo(result);
            }

            @Override
            public void onError(String error) {
                Log.e("PokedexSpecificC", "Error loading data: " + error);
            }
        });
    }
    public String getUserName() {
        return game.getUserName();
    }

    public void loadTeam() {
        for(String pokemon : game.getTeam()){
            loadData("https://pokeapi.co/api/v2/pokemon/" + pokemon);
        }
    }
}
