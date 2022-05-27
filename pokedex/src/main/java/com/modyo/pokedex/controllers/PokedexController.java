package com.modyo.pokedex.controllers;

import com.modyo.pokedex.dto.PokemonResponse;
import com.modyo.pokedex.dto.Response;
import com.modyo.pokedex.models.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "v1/pokedex")
public class PokedexController {

    private static final Logger logger = LoggerFactory.getLogger(PokedexController.class.getSimpleName());

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("getPokemonByName/{nameOrId}")
    public ResponseEntity<Response<PokemonResponse>> pokemonController(@PathVariable String nameOrId) throws Exception {
        logger.info("Ingresando al servicio para obtener informacion basica del pokemon");
        PokemonResponse pokemonResponse = pokemonService.getPokemon(nameOrId);
        Response<PokemonResponse> response = new Response<>(HttpStatus.OK.value(), "Found", pokemonResponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}