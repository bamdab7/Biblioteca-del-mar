package edu.nerea.proyecto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.nerea.proyecto.biblioteca.entity.Libro;
import edu.nerea.proyecto.biblioteca.service.ILibroService;

@Controller //cambiar a controller al mostrar vistas html
public class LibroController {

	@Autowired
	private ILibroService serviceLibros;
	
		//esta ruta nos mostrara un listado de los libros (tabla)
	@GetMapping("/libros")
	public String mostrarLibros(Model model) {
		List<Libro> lista= serviceLibros.buscarTodosLibros();
		model.addAttribute("libros", lista);
		return "catalogo/productos.html";
	}
	//metodo guardar libros
	/*@PostMapping("/addLibro")
	public Libro guardarLibro(@RequestBody Libro libro) {
		return serviceLibros.guardarLibro(libro);
	}
	*/
}
