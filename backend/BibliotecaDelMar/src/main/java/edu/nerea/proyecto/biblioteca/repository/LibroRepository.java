package edu.nerea.proyecto.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.nerea.proyecto.biblioteca.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
