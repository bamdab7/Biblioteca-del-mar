package edu.nerea.proyecto.biblioteca.service;

import java.util.List;

import edu.nerea.proyecto.biblioteca.entity.Libro;

public interface ILibroService {

	//en esta clase lo que haremos será declarar los métodos que usaremos relacionados con los libros
	List<Libro> buscarTodosLibros();
}
