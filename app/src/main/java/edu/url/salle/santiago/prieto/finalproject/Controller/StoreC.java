package edu.url.salle.santiago.prieto.finalproject.Controller;

import org.json.JSONObject;

import edu.url.salle.santiago.prieto.finalproject.Model.BusinessGame;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokeball;
import edu.url.salle.santiago.prieto.finalproject.Model.PokeAPI.ObtainData;
import edu.url.salle.santiago.prieto.finalproject.View.StoreV;

public class StoreC {
    private StoreV storeV;
    private ObtainData obtainData;

    private BusinessGame game;
    public StoreC(StoreV storeV){
        this.storeV = storeV;
        this.obtainData = new ObtainData(storeV);
    }


    public void loadData() {

    }
    public void buyPokeball(Pokeball.PokeballType pokeballType) {
        storeV.updateMoney(game.buyPokeball(pokeballType));
    }

    public long getMoney() {
        return game.getMoney();
    }
}
