package edu.url.salle.santiago.prieto.finalproject.Model.Entities;

public class Pokeball {
    public enum PokeballType {
        POKEBALL, SUPERBALL, ULTRABALL, MASTERBALL
    }

    public static int getPrice(PokeballType type) {
        switch (type) {
            case POKEBALL:
                return 200;
            case SUPERBALL:
                return 500;
            case ULTRABALL:
                return 1500;
            case MASTERBALL:
                return 100000;
        }
        return 0;
    }

    public static float getSuccessRate(int pokemonType, PokeballType type) {
        switch (type) {
            case POKEBALL:
                return (float) ((600.0 - pokemonType) / 600.0);
            case SUPERBALL:
                return (float) (((600.0 - pokemonType) / 600.0) * 1.5);
            case ULTRABALL:
                return (float) (((600.0 - pokemonType) / 600.0) * 2);
            case MASTERBALL:
                return 1.0F;
        }
        return 0;
    }
}

    