package edu.nerea.proyecto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import edu.nerea.proyecto.biblioteca.entity.Libro;
import edu.nerea.proyecto.biblioteca.service.ILibroService;

@Controller //cambiar a controller al mostrar vistas html (restcontroller, controller)
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
	
		//esta ruta nos mostrara en detalle el producto que filtraremos por el id
	@GetMapping("/detalle/{id}")
	public String verDetalle(@PathVariable("id") int idLibro,Model model) {
		Libro libro= serviceLibros.buscarPorId(idLibro);
		model.addAttribute("libro", libro);
		return "catalogo/detalle.html";
	}
	

	//pageable
}
