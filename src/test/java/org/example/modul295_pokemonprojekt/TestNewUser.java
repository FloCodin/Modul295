package org.example.modul295_pokemonprojekt;

import org.example.modul295_pokemonprojekt.model.User;
import org.example.modul295_pokemonprojekt.repository.UserRepository;
import org.example.modul295_pokemonprojekt.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class userServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public userServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setName("Misty");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.saveUser(user);

        assertNotNull(createdUser);
        verify(userRepository, times(1)).save(user);
    }
}
