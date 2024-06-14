package edu.url.salle.santiago.prieto.finalproject.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import edu.url.salle.santiago.prieto.finalproject.Controller.PokedexSpecificC;
import edu.url.salle.santiago.prieto.finalproject.R;

public class PokedexSpecificV extends AppCompatActivity {
    private PokedexSpecificC pokedexSpecificC;
    private TextView pokemonName;
    private ImageView frontImageView, rearImageView;
    private Button captureButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokedex_specific);

        // finding views
        pokemonName = findViewById(R.id.pokemonName);
        captureButton = findViewById(R.id.captureButton);
        backButton = findViewById(R.id.backButton);
        frontImageView = findViewById(R.id.frontImageView);
        rearImageView = findViewById(R.id.rearImageView);

        // setting-up button listeners
        captureButton.setOnClickListener(v -> {
            // Handle capture button click
        });

        backButton.setOnClickListener(v -> {
            // Handle back button click
            onBackPressed();
        });

        Intent intent = getIntent();
        String pokemonNameStr = intent.getStringExtra("pokemonName");

        pokedexSpecificC = new PokedexSpecificC(this);
        pokedexSpecificC.loadData("https://pokeapi.co/api/v2/pokemon/" + pokemonNameStr);
    }

    public void showInfo(JSONObject result) {
        try{
            pokemonName.setText(result.getString("name"));
            String imageUrl1 = (result.getJSONObject("sprites")).getString("front_default");
            Picasso.get().load(imageUrl1).into(frontImageView);
            String imageUrl2 = (result.getJSONObject("sprites")).getString("back_default");
            Picasso.get().load(imageUrl2).into(rearImageView);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
