package edu.nerea.proyecto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nerea.proyecto.biblioteca.entity.Libro;
import edu.nerea.proyecto.biblioteca.service.ILibroService;

@RestController //cambiar a controller al mostrar vistas html
public class LibroController {

	@Autowired
	private ILibroService serviceLibros;
	
	@GetMapping("/libros")
	public List<Libro>mostrarLibros() {
		return serviceLibros.buscarTodosLibros();
	}
}
