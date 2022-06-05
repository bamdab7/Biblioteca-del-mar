package edu.nerea.proyecto.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.nerea.proyecto.biblioteca.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
}
