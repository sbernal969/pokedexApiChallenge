package com.modyo.pokedex.models.service;

import com.modyo.pokedex.clients.PokeApiClientRest;
import com.modyo.pokedex.dto.PokemonResponse;
import com.modyo.pokedex.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PokemonServiceImpl implements  PokemonService{

    @Autowired(required = true)
    private PokeApiClientRest pokeApiClientRest;
    private static final Logger logger = LoggerFactory.getLogger(PokemonServiceImpl.class.getSimpleName());

    @Override
    public PokemonResponse getPokemon(String nameOrId) throws Exception {
        logger.info("Inicio impl obtiene pokemon {}", nameOrId);
        PokemonResponse pokemonResponse = new PokemonResponse();
        pokemonResponse = pokeApiClientRest.getPokemon(Constant.httpHeaders.HTTP_HEADER_USER_AGENT,nameOrId);
        logger.info("Respuesta REST pokemonResponse {}", pokemonResponse.getName());

        return pokemonResponse;

    }

}
