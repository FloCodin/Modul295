import org.example.modul295_pokemonprojekt.model.Pokemon;
import org.example.modul295_pokemonprojekt.model.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static jdk.internal.classfile.impl.verifier.VerifierImpl.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Test
void testGetFavoritePokemonsByUserId() {
    User user = new User();
    user.setId(1L);

    List<Pokemon> favoritePokemons = Arrays.asList(
            new Pokemon("Charizard", true, user),
            new Pokemon("Blastoise", true, user)
    );

    when(pokemonRepository.findByUserIdAndIsFavoriteTrue(1L)).thenReturn(favoritePokemons);

    List<Pokemon> result = pokemonService.getFavoritePokemonsByUserId(1L);

    assertEquals(2, result.size());
    assertEquals("Charizard", result.get(0).getName());
    assertEquals("Blastoise", result.get(1).getName());
    verify(pokemonRepository, times(1)).findByUserIdAndIsFavoriteTrue(1L);
}
void testGetFavoritePokemonsByUserId() {
    User user = new User();
    user.setId(1L);

    List<Pokemon> favoritePokemons = Arrays.asList(
            new Pokemon("Charizard", true, user),
            new Pokemon("Blastoise", true, user)
    );

    when(pokemonRepository.findByUserIdAndIsFavoriteTrue(1L)).thenReturn(favoritePokemons);

    List<Pokemon> result = pokemonService.getFavoritePokemonsByUserId(1L);

    assertEquals(2, result.size());
    assertEquals("Charizard", result.get(0).getName());
    assertEquals("Blastoise", result.get(1).getName());
    verify(pokemonRepository, times(1)).findByUserIdAndIsFavoriteTrue(1L);
}
