package edu.url.salle.santiago.prieto.finalproject.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.url.salle.santiago.prieto.finalproject.Controller.PokedexC;
import edu.url.salle.santiago.prieto.finalproject.Controller.PokemonAdapter;
import edu.url.salle.santiago.prieto.finalproject.R;

public class PokedexV extends AppCompatActivity {
    private PokedexC pokedexC;
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private TextView titleTextView;
    private EditText searchEditText;
    private Button buttonPokedex, buttonTrainer, buttonStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokedex);

        // finding views
        titleTextView = findViewById(R.id.titleTextView);
        searchEditText = findViewById(R.id.searchEditText);
        recyclerView = findViewById(R.id.recyclerView);
        buttonPokedex = findViewById(R.id.buttonPokedex);
        buttonTrainer = findViewById(R.id.buttonTrainer);
        buttonStore = findViewById(R.id.buttonStore);

        // setting-up RecyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1)); // 3 columns
        pokemonAdapter = new PokemonAdapter(this);
        recyclerView.setAdapter(pokemonAdapter);

        // setting-up button listeners
        buttonPokedex.setOnClickListener(v -> {
            // Handle Pokedex button click
            // You can update the RecyclerView data or perform other actions
        });

        buttonTrainer.setOnClickListener(v -> {
            // Handle Trainer button click
            // You can update the RecyclerView data or perform other actions
        });

        buttonStore.setOnClickListener(v -> {
            // Handle Store button click
            // You can update the RecyclerView data or perform other actions
        });

        pokedexC = new PokedexC(this);
        // url to get all pokemon: "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=1302"
        // to get 15x15: 15*15 = 255, so "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=225"
        pokedexC.loadData("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=225", pokemonAdapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void showInfo(PokemonAdapter pokemonAdapter) {
        // set views based on the JSON object
        // updating the RecyclerView with new data
        pokedexC.getImages(pokemonAdapter);
        pokemonAdapter.notifyDataSetChanged();
    }
}
