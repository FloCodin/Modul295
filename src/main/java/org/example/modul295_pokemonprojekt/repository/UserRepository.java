package org.example.modul295_pokemonprojekt.repository;


import org.example.modul295_pokemonprojekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

