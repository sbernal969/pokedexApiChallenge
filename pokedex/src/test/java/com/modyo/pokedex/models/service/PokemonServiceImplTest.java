package com.modyo.pokedex.models.service;

import com.modyo.pokedex.clients.PokeApiClientRest;
import com.modyo.pokedex.dto.PokemonResponse;
import com.modyo.pokedex.dto.in.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class PokemonServiceImplTest {
    @Mock
    private PokeApiClientRest pokeApiClientRest;

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    private PokemonResponse pokemonResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        List<Abilities> abilitiesList = new ArrayList<Abilities>();
        Abilities abilities = new Abilities();
        abilities.setAbility(new Ability("fly"));
        abilitiesList.add(abilities);

        List<Types> typesList = new ArrayList<Types>();
        Types types = new Types();
        types.setType(new Type("fire"));
        typesList.add(types);

        pokemonResponse = new PokemonResponse();
        pokemonResponse.setId(2);
        pokemonResponse.setName("ivysaur");
        pokemonResponse.setSprites(new Sprites("xyz"));
        pokemonResponse.setTypes(typesList);
        pokemonResponse.setWeight("130");
        pokemonResponse.setAbilities(abilitiesList);
    }

    @Test
    void getPokemon() throws Exception {
        when(pokeApiClientRest.getPokemon("2")).thenReturn(pokemonResponse);
        assertNotNull(pokemonService.getPokemon("2"));
    }
}