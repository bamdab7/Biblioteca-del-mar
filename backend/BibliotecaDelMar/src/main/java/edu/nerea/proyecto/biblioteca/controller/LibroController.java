package edu.nerea.proyecto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.nerea.proyecto.biblioteca.entity.Libro;
import edu.nerea.proyecto.biblioteca.service.IAutorService;
import edu.nerea.proyecto.biblioteca.service.IEditorialService;
import edu.nerea.proyecto.biblioteca.service.ILibroService;

@Controller //cambiar a controller al mostrar vistas html (restcontroller, controller)
public class LibroController {

	@Autowired
	private ILibroService serviceLibros;
	@Autowired
	private IEditorialService serviceEditorial;
	@Autowired
	private IAutorService serviceAutor;

	
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

	@PostMapping("/saveLibro") //BindingResult para capturar los errores de conversion del formulario
	public String crearLibro(Libro libro,BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			for(ObjectError error : result.getAllErrors()){
				System.out.println("Error: " + error.getDefaultMessage());
			} //nos informa que error se esta cometiendo y nos devuelve al formulario
			return "form/addLibro.html";
		}

		serviceLibros.guardarLibro(libro);
		attributes.addFlashAttribute ("msg", "Se ha guardado el producto correctamente");
		return "redirecatalogo/productos.html";
	}

		//esta ruta nos permitira crear productos FALTA IMAGEN Y AUTOR Y EDITORIAL
	@GetMapping("/createLibro")
	public String crearLibro(Libro libro){
		return "forms/addLibro.html";
	}
		//el metodo editar recoge el id que seleccionamos, muestra todos los datos en un formulario, editaremos y actualizaremos
	@GetMapping("/editLibro/{id}")
	public String editLibro(@PathVariable("id") int idLibro,Model model){
		Libro libro=serviceLibros.buscarPorId(idLibro);
		model.addAttribute("libro",libro);
		return "forms/addLibro.html";
	}

	@GetMapping("/eliminarLibro/{id}")
	public String eliminarLibro(@RequestParam("id") int idLibro, RedirectAttributes attributes){
		serviceLibros.eliminar(idLibro);
		attributes.addFlashAttribute("msg", "Ha eliminado el producto"); //añadiendo mensaje que muestra info al usuario de acciones
		return "redirect:/catalogo/productos.html"; //redireccionamiento al listado de los productos
	}

	@ModelAttribute //cada metodo del controlador endra informacion de editoriales y autores, asi nos evitamos insertarla cada vez EL MODEL TENDRA INFO
	public void setGenericos(Model model){
		model.addAttribute("editoriales", serviceEditorial.buscarTodasEditoriales());
		model.addAttribute("autores", serviceAutor.buscarTodosAutores());
	}
	
	//pageable
}
