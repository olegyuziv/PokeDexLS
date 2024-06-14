package edu.url.salle.santiago.prieto.finalproject.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokeball;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.Pokemon;
import edu.url.salle.santiago.prieto.finalproject.Model.Entities.PokemonGroup;
import edu.url.salle.santiago.prieto.finalproject.View.PokedexSpecificV;
import edu.url.salle.santiago.prieto.finalproject.View.PokedexV;
import edu.url.salle.santiago.prieto.finalproject.R;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private static List<PokemonGroup> pokemonGroupList; // list of all pokemon in recycler view
    @SuppressLint("StaticFieldLeak")
    public static PokedexV pokedexV;

    public PokemonAdapter(PokedexV pokedexV) {
        PokemonAdapter.pokedexV = pokedexV;
        pokemonGroupList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        PokemonGroup pokemonGroup = pokemonGroupList.get(position);

        holder.pokemonNameTextView1.setText(pokemonGroup.getPokemon1().getName());
        String imageUrl1 = pokemonGroup.getPokemon1().getImageResource();
        String imageUrl2 = pokemonGroup.getPokemon2().getImageResource();
        String imageUrl3 = pokemonGroup.getPokemon3().getImageResource();
        if (!imageUrl1.endsWith(".png")) {
            imageUrl1 = imageUrl2 = imageUrl3 = "https://raw.githubusercontent.com/google/material-design-icons/master/png/notification/sync/materialicons/48dp/1x/baseline_sync_black_48dp.png";
        }
        Picasso.get().load(imageUrl1).into(holder.pokemonImageView1);
        holder.pokeballImageView1.setImageResource(R.drawable.poke_ball);

        holder.pokemonNameTextView2.setText(pokemonGroup.getPokemon2().getName());
        Picasso.get().load(imageUrl2).into(holder.pokemonImageView2);
        holder.pokeballImageView2.setImageResource(R.drawable.poke_ball);

        holder.pokemonNameTextView3.setText(pokemonGroup.getPokemon3().getName());
        Picasso.get().load(imageUrl3).into(holder.pokemonImageView3);
        holder.pokeballImageView3.setImageResource(R.drawable.poke_ball);

        // Set click listeners for each individual Pokémon
        holder.pokemonImageView1.setOnClickListener(v -> navigateToPokemonDetail(pokemonGroup.getPokemon1().getName()));
        holder.pokemonImageView2.setOnClickListener(v -> navigateToPokemonDetail(pokemonGroup.getPokemon2().getName()));
        holder.pokemonImageView3.setOnClickListener(v -> navigateToPokemonDetail(pokemonGroup.getPokemon3().getName()));
    }

    private void navigateToPokemonDetail(String pokemonName) {
        Intent intent = new Intent(pokedexV, PokedexSpecificV.class);
        intent.putExtra("pokemonName", pokemonName);
        pokedexV.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return pokemonGroupList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void loadJSON(JSONObject allData) {
        JSONArray jsonArray;
        JSONObject jsonObject;
        int i = 0;

        try {
            jsonArray = allData.getJSONArray("results");
        } catch (JSONException e) {
            return;
        }

        try {
            while (i <= allData.getInt("count")) {
                jsonObject = jsonArray.getJSONObject(i);
                Pokemon p1 = new Pokemon(jsonObject.getString("name"), jsonObject.getString("url"), Pokeball.PokeballType.POKEBALL);
                i = i + 1 <= 1302 ? i + 1 : i;
                jsonObject = jsonArray.getJSONObject(i);
                Pokemon p2 = new Pokemon(jsonObject.getString("name"), jsonObject.getString("url"), Pokeball.PokeballType.POKEBALL);
                i = i + 1 <= 1302 ? i + 1 : i;
                jsonObject = jsonArray.getJSONObject(i);
                Pokemon p3 = new Pokemon(jsonObject.getString("name"), jsonObject.getString("url"), Pokeball.PokeballType.POKEBALL);
                i = i + 1 <= 1302 ? i + 1 : i;

                PokemonGroup pokemonGroup = new PokemonGroup(p1, p2, p3);
                pokemonGroupList.add(pokemonGroup);
            }
        } catch (JSONException e) {
            return;
        }

        notifyDataSetChanged();
    }

    public List<PokemonGroup> getPokemonGroupList() {
        return pokemonGroupList;
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        ImageView pokemonImageView1;
        TextView pokemonNameTextView1;
        ImageView pokeballImageView1;
        ImageView pokemonImageView2;
        TextView pokemonNameTextView2;
        ImageView pokeballImageView2;
        ImageView pokemonImageView3;
        TextView pokemonNameTextView3;
        ImageView pokeballImageView3;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonImageView1 = itemView.findViewById(R.id.pokemonImageView1);
            pokemonNameTextView1 = itemView.findViewById(R.id.pokemonNameTextView1);
            pokeballImageView1 = itemView.findViewById(R.id.pokeballImageView1);
            pokemonImageView2 = itemView.findViewById(R.id.pokemonImageView2);
            pokemonNameTextView2 = itemView.findViewById(R.id.pokemonNameTextView2);
            pokeballImageView2 = itemView.findViewById(R.id.pokeballImageView2);
            pokemonImageView3 = itemView.findViewById(R.id.pokemonImageView3);
            pokemonNameTextView3 = itemView.findViewById(R.id.pokemonNameTextView3);
            pokeballImageView3 = itemView.findViewById(R.id.pokeballImageView3);
        }
    }
}
