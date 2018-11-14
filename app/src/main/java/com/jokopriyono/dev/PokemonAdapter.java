package com.jokopriyono.dev;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
    List<PokemonData> pokemon;
    private Context context;

    PokemonAdapter(Context context, List<PokemonData> pokemon) {
        this.context = context;
        this.pokemon = pokemon;
    }

    @NonNull
    @Override
    public PokemonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.ViewHolder holder, int i) {
        final int position = i;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailActivity.class)
                        .putExtra(DetailActivity.INTENT_DATA, pokemon.get(position)));
            }
        });
        holder.textPokemon.setText(pokemon.get(i).getName());
        holder.imgPokemon.setImageResource(pokemon.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textPokemon;
        ImageView imgPokemon;

        ViewHolder(@NonNull View v) {
            super(v);
            cardView = v.findViewById(R.id.card_view);
            textPokemon = v.findViewById(R.id.txt_pokemon);
            imgPokemon = v.findViewById(R.id.img_pokemon);
        }
    }
}
