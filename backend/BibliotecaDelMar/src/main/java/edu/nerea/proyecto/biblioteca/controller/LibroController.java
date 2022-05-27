package edu.nerea.proyecto.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibroController {


	@GetMapping("/libros")
	public String mostrarLibros() {
		return "catalogo/productos.html";
	}
}
