package edu.nerea.proyecto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

		//esta ruta nos permitira crear productos FALTA IMAGEN Y AUTOR Y EDITORIAL
	@GetMapping("/createLibro")
	public String crearLibro(){
		return "forms/addLibro.html";
	}

	@PostMapping("/saveLibro") //BindingResult para capturar los errores de conversion del formulario
	public String crearLibro(Libro libro,BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			for(ObjectError error : result.getAllErrors()){
				System.out.println("Error: " + error.getDefaultMessage());
			} //nos informa que error se esta cometiendo y nos devuelve al formulario
			return "form/addLibro.html";
		}
		serviceLibros.guardarLibro(libro);
	//	List<Libro> lista = serviceLibros.buscarTodosLibros();
	//	model.addAttribute("libros", lista); //asi una vez guardado pille los libros y los liste
		attributes.addFlashAttribute ("msg", "Se ha guardado el producto correctamente");
		return "catalogo/productos.html";
	}

		//a revisar
	@GetMapping("/editLibro/{id}")
	public String editLibro(@PathVariable("id") int idLibro,Model model){
		Libro libro=serviceLibros.buscarPorId(idLibro);
		model.addAttribute("libro",libro);
		return "forms/addLibro.html";
	}

	@GetMapping("/eliminarLibro/{id}")
	public String eliminarLibro(@RequestParam("id") int idLibro, Model model){
		model.addAttribute("libro", idLibro);
		return null;
	}

	//pageable
}
