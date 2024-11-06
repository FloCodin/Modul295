package org.example.modul295_pokemonprojekt.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean isFavorite;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
