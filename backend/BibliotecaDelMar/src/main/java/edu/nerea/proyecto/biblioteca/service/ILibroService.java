package edu.nerea.proyecto.biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.nerea.proyecto.biblioteca.entity.Libro;

public interface ILibroService {

	//en esta clase lo que haremos será declarar los métodos que usaremos relacionados con los libros
	List<Libro> buscarTodosLibros();
	void guardarLibro(Libro libro);
	Libro buscarPorId(Integer idLibro);
	void eliminar (Integer idLibro);
		//esto paginará lo que listaremos en el findAll()
	Page<Libro> buscarTodosLibros(Pageable page);
} 
