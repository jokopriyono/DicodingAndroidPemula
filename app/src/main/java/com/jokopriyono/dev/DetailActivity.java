package com.jokopriyono.dev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_DATA = "data";
    private ImageView imgPokemon;
    private TextView txtDesc;
    private TextView txtType;
    private TextView txtElement1;
    private TextView txtElement2;
    private TextView txtElement3;
    private TextView txtElement4;
    private TextView txtElement5;
    private TextView txtElement6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgPokemon = findViewById(R.id.img_pokemon);
        txtDesc = findViewById(R.id.txt_desc);
        txtType = findViewById(R.id.txt_type);
        txtElement1 = findViewById(R.id.txt_element_1);
        txtElement2 = findViewById(R.id.txt_element_2);
        txtElement3 = findViewById(R.id.txt_element_3);
        txtElement4 = findViewById(R.id.txt_element_4);
        txtElement5 = findViewById(R.id.txt_element_5);
        txtElement6 = findViewById(R.id.txt_element_6);

        if (getIntent().getExtras() != null) {
            PokemonData pokemonData = (PokemonData) getIntent().getExtras().getSerializable(INTENT_DATA);
            if (pokemonData != null) {
                loadPokemonData(pokemonData);
            }
        }
    }

    private void loadPokemonData(PokemonData pokemonData) {
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(pokemonData.getName());
        imgPokemon.setImageResource(pokemonData.getImage());
        txtDesc.setText(pokemonData.getDescription());
        txtType.setText(pokemonData.getType());
        if (pokemonData.getElement1() != 0) switchStyleElements(pokemonData.getElement1());
        if (pokemonData.getElement2() != 0) switchStyleElements(pokemonData.getElement2());
    }

    private void switchStyleElements(int element) {
        switch (element) {
            case 1:
                txtElement1.setVisibility(View.VISIBLE);
                break;
            case 2:
                txtElement2.setVisibility(View.VISIBLE);
                break;
            case 3:
                txtElement3.setVisibility(View.VISIBLE);
                break;
            case 4:
                txtElement4.setVisibility(View.VISIBLE);
                break;
            case 5:
                txtElement5.setVisibility(View.VISIBLE);
                break;
            case 6:
                txtElement6.setVisibility(View.VISIBLE);
                break;
        }
    }
}
