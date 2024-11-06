package org.example.modul295_pokemonprojekt;

import org.example.modul295_pokemonprojekt.model.Pokemon;
import org.example.modul295_pokemonprojekt.model.User;
import org.example.modul295_pokemonprojekt.repository.PokemonRepository;
import org.example.modul295_pokemonprojekt.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PokemonServiceTest {

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonService pokemonService;

    public PokemonServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPokemonsByUserId() {
        User user = new User();
        user.setId(1L);

        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon("Pikachu", false, user),
                new Pokemon("Charizard", true, user)
        );

        when(pokemonRepository.findByUserId(1L)).thenReturn(pokemons);

        List<Pokemon> result = pokemonService.getPokemonsByUserId(1L);

        assertEquals(2, result.size());
        assertEquals("Pikachu", result.get(0).getName());
        assertEquals("Charizard", result.get(1).getName());
        verify(pokemonRepository, times(1)).findByUserId(1L);
    }
}
