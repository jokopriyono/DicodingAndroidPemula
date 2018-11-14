package com.jokopriyono.dev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PokemonActivity extends AppCompatActivity {
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));
        loadPokemon();
    }

    private void loadPokemon() {
        List<PokemonData> pokemonData = new ArrayList<>();
        String[] pokemon = getResources().getStringArray(R.array.pokemon);
        String[] pokemonDesc = getResources().getStringArray(R.array.pokemon_desc);
        String[] pokemonType = getResources().getStringArray(R.array.pokemon_type);
        int[] element1 = getResources().getIntArray(R.array.element1);
        int[] element2 = getResources().getIntArray(R.array.element2);
        Integer[] pokemonImage = {R.drawable.snorlax,
                R.drawable.abra,
                R.drawable.bulbasaur,
                R.drawable.pikachu,
                R.drawable.psyduck,
                R.drawable.rattata};
        for (int i = 0; i < pokemon.length; i++) {
            String name = "", desc = "", type = "";
            Integer image;
            if (pokemon[i] != null) name = pokemon[i];
            if (pokemonDesc[i] != null) desc = pokemonDesc[i];
            if (pokemonType[i] != null) type = pokemonType[i];
            image = pokemonImage[i];
            pokemonData.add(new PokemonData(name, image, desc, type, element1[i], element2[i]));
        }
        PokemonAdapter adapter = new PokemonAdapter(this, pokemonData);
        recycler.setAdapter(adapter);
    }
}
