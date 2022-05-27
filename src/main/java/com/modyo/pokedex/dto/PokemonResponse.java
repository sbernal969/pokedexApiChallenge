package com.modyo.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modyo.pokedex.dto.in.Abilities;
import com.modyo.pokedex.dto.in.Sprites;
import com.modyo.pokedex.dto.in.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sprites")
    private Sprites sprites;
    @JsonProperty("types")
    private List<Types> types;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("abilities")
    private List<Abilities> abilities;
}
