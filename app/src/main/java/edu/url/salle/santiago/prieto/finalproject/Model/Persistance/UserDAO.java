package edu.url.salle.santiago.prieto.finalproject.Model.Persistance;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokeball;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.User;

public class UserDAO {
    private final String path = "src/shop.json";

    public boolean saveUser(String name, long money, ArrayList<String> team,  ArrayList<String> teamBalls, int pokeballAm, int superballAm, int ultraballAm, int masterballAm){
        try {


            JSONObject pokeballs = new JSONObject();

            pokeballs.put("pokeball", pokeballAm);
            pokeballs.put("superball", superballAm);
            pokeballs.put("ultraball", ultraballAm);
            pokeballs.put("masterball", masterballAm);

            JSONObject data = new JSONObject();
            JSONArray teamArray = new JSONArray();
            for (int i = 0; i < team.size(); i++) {
                JSONObject pokemon = new JSONObject();
                pokemon.put("name", team.get(i));
                pokemon.put("pokeball", teamBalls.get(i));
                teamArray.put(pokemon);
            }
            data.put("name", name);
            data.put("money", money);
            data.put("team", teamArray);
            data.put("pokeballs", pokeballs);

            try (FileWriter file = new FileWriter("user.json")) {
                file.write(data.toString(4));
                return true;
            }catch (Exception e){
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public boolean saveUser(User user) {
        try {

            JSONObject pokeballs = new JSONObject();
            pokeballs.put("pokeball", user.getPokeballAm());
            pokeballs.put("superball", user.getSuperballAm());
            pokeballs.put("ultraball", user.getUltraballAm());
            pokeballs.put("masterball", user.getMasterballAm());


            JSONObject data = new JSONObject();
            JSONArray teamArray = new JSONArray();
            ArrayList<String> team = user.getTeam();
            ArrayList<Pokeball.PokeballType> teamBalls = user.getPokeballs();
            for (int i = 0; i < team.size(); i++) {
                JSONObject pokemon = new JSONObject();
                pokemon.put("name", team.get(i));
                pokemon.put("pokeball", teamBalls.get(i).name());
                teamArray.put(pokemon);
            }
            data.put("name", user.getName());
            data.put("money", user.getMoney());
            data.put("team", teamArray);
            data.put("pokeballs", pokeballs);


            try (FileWriter file = new FileWriter("user.json")) {
                file.write(data.toString(4));
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


    public User getUser() throws JSONException, IOException {
        String name;
        long money;
        ArrayList<String> team = new ArrayList<>();
        ArrayList<Pokeball.PokeballType> pokeballs = new ArrayList<>();
        int pokeballAm = 0, superballAm = 0, ultraballAm = 0, masterballAm = 0;

        String content = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            content = new String(Files.readAllBytes(Paths.get(path)));
        }

        JSONObject data = new JSONObject(content);
        name = data.getString("team");
        money = data.getLong("money");
        JSONArray teamArray = data.getJSONArray("team");
        for (int i = 0; i < teamArray.length(); i++) {
            JSONObject pokemon = teamArray.getJSONObject(i);
            team.add(pokemon.getString("name"));
            pokeballs.add(Pokeball.PokeballType.valueOf(pokemon.getString("pokeball").toUpperCase()));
        }
        JSONObject pokeballsJson = data.getJSONObject("pokeballs");
        pokeballAm = pokeballsJson.getInt("pokeball");
        superballAm = pokeballsJson.getInt("superball");
        ultraballAm = pokeballsJson.getInt("ultraball");
        masterballAm = pokeballsJson.getInt("masterball");


        return new User(name, money, team, pokeballs, pokeballAm, superballAm, ultraballAm, masterballAm);
    }
}
