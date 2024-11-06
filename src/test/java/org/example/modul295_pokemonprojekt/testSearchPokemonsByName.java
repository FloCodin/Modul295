package org.example.modul295_pokemonprojekt;

import org.example.modul295_pokemonprojekt.model.Pokemon;

import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@Test
void testSearchPokemonsByName() {
    List<Pokemon> pokemons = Arrays.asList(
            new Pokemon("Pikachu", false, null),
            new Pokemon("Pidgey", false, null)
    );

    when(pokemonRepository.findByNameContainingIgnoreCase("Pi")).thenReturn(pokemons);

    List<Pokemon> result = pokemonService.searchPokemonsByName("Pi");

    assertEquals(2, result.size());
    assertEquals("Pikachu", result.get(0).getName());
    assertEquals("Pidgey", result.get(1).getName());
    verify(pokemonRepository, times(1)).findByNameContainingIgnoreCase("Pi");
}
