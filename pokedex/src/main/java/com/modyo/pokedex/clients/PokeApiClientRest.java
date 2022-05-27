package com.modyo.pokedex.clients;

import com.modyo.pokedex.config.FeignSimpleEncoderConfig;
import com.modyo.pokedex.dto.PokemonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="pokeApi", url = "https://pokeapi.co/api/v2/pokemon/", configuration = FeignSimpleEncoderConfig.class)
public interface PokeApiClientRest {

    @GetMapping(value ={"{name}"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    PokemonResponse getPokemon(@PathVariable("name") String name);

}
