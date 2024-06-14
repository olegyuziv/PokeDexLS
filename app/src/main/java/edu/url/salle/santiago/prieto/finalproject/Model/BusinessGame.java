package edu.url.salle.santiago.prieto.finalproject.Model;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokeball;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.User;
import edu.url.salle.santiago.prieto.finalproject.Model.Persistance.UserDAO;

public class BusinessGame {
    private long money;
    private UserDAO userDAO;
    private User user;

    public BusinessGame() throws JSONException, IOException {
        money = 0;
        userDAO = new UserDAO();
        user = userDAO.getUser();
    }

    public long buyPokeball(Pokeball.PokeballType type){
        user.addBall(type);
        money = money - Pokeball.getPrice(type);
        userDAO.saveUser(user);
        return money;
    }

    public boolean removePokemon(String pokemon){
        if(user.removePokemon(pokemon)){
            userDAO.saveUser(user);
            return true;
        }
        return false;
    }

    public boolean capturePokemon(String pokemon, Pokeball.PokeballType type, float chance){
        Random random = new Random();
        if(user.getTeam().size() < 6){
            if(random.nextDouble() < chance){
                user.addPokemon(pokemon, type);
                userDAO.saveUser(user);
                return true;
            }
        }

        return false;
    }

    public String getUserName() {
        return user.getName();
    }

    public long getMoney() {
        return user.getMoney();
    }

    public ArrayList<String> getTeam() {
        return user.getTeam();
    }
}
