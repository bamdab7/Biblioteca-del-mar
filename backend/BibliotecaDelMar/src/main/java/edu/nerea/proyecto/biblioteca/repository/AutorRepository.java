package edu.nerea.proyecto.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.nerea.proyecto.biblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{
    
}
