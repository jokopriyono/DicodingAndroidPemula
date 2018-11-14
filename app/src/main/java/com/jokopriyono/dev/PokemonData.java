package com.jokopriyono.dev;

import java.io.Serializable;

public class PokemonData implements Serializable {
    private String name;
    private Integer image;
    private String description;
    private String type;
    private Integer element1;
    private Integer element2;

    public PokemonData(String name, Integer image, String description, String type, Integer element1, Integer element2) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.type = type;
        this.element1 = element1;
        this.element2 = element2;
    }

    public String getName() {
        return name;
    }

    public Integer getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Integer getElement1() {
        return element1;
    }

    public Integer getElement2() {
        return element2;
    }
}
