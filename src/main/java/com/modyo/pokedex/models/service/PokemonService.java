package com.modyo.pokedex.models.service;

import com.modyo.pokedex.dto.PokemonResponse;
import org.springframework.stereotype.Service;

@Service
public interface PokemonService {
    PokemonResponse getPokemon(String nameOrId) throws Exception;
}
