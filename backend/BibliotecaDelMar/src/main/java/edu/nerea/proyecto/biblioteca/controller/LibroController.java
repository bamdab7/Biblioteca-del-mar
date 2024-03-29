package edu.nerea.proyecto.biblioteca.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.security.core.Authentication;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.nerea.proyecto.biblioteca.entity.Libro;
import edu.nerea.proyecto.biblioteca.entity.Usuario;
import edu.nerea.proyecto.biblioteca.service.IAutorService;
import edu.nerea.proyecto.biblioteca.service.IEditorialService;
import edu.nerea.proyecto.biblioteca.service.ILibroService;
import edu.nerea.proyecto.biblioteca.service.IUsuariosService;

@Controller //cambiar a controller al mostrar vistas html (restcontroller, controller)
public class LibroController {

	@Autowired
	private ILibroService serviceLibros;
	@Autowired
	private IEditorialService serviceEditorial;
	@Autowired
	private IAutorService serviceAutor;
	@Autowired
	private IUsuariosService serviceUsuarios;

	
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
	public String crearLibro(Libro libro,BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile imagen) throws IOException{
		if(result.hasErrors()){
			for(ObjectError error : result.getAllErrors()){
				System.out.println("Error: " + error.getDefaultMessage());
			} //nos informa que error se esta cometiendo y nos devuelve al formulario
			return "form/addLibro.html";
		}
		//System.out.println(imagen);
		InputStream initialStream = imagen.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File file = new File("src/main/resources/static/img/" + libro.getTitulo()+ ".jpg"); //guardamos la imagen

        try (OutputStream outStream = new FileOutputStream(file)) {
            outStream.write(buffer);
        }
       // imagenArchivo= libro.getTitulo()+ "jpg";
        libro.setImagen(file.getName());
		serviceLibros.guardarLibro(libro);
		attributes.addFlashAttribute ("msg", "Se ha guardado el producto correctamente");
		return "redirect:/libros";
	}

	@GetMapping("/createLibro")
	public String crearLibro(Libro libro){
		return "forms/addLibro.html";
	}
		//el metodo editar recoge el id que seleccionamos, muestra todos los datos en un formulario, editaremos y actualizaremos
	@GetMapping("/editLibro/{id}")
	public String editLibro(@PathVariable("id") Integer idLibro,Model model){
		Libro libro=serviceLibros.buscarPorId(idLibro);
		model.addAttribute("libro",libro);
		return "forms/addLibro.html";
	}

	@GetMapping("/eliminarLibro/{id}")
	public String eliminarLibro(@PathVariable("id") Integer idLibro, RedirectAttributes attributes){
		serviceLibros.eliminar(idLibro);
		attributes.addFlashAttribute("msg", "Ha eliminado el producto"); //añadiendo mensaje que muestra info al usuario de acciones
		return "redirect:/libros"; //redireccionamiento al listado de los productos
	}

	@ModelAttribute //cada metodo del controlador endra informacion de editoriales y autores, asi nos evitamos insertarla cada vez EL MODEL TENDRA INFO
	public void setGenericos(Model model){
		model.addAttribute("editoriales", serviceEditorial.buscarTodasEditoriales());
		model.addAttribute("autores", serviceAutor.buscarTodosAutores());
	}
	
	//pageable
	
	//añadiendo libros a los usuarios, primero tendremos que obtener el usuario que esta logeado
	@GetMapping("/reservar/{id}")
	public String reserve(@PathVariable("id") Integer idLibro,Authentication auth) {
		String username = auth.getName();	
		serviceUsuarios.addReservas(username, idLibro);
		return "redirect:/mostrarReserva" ;
	}
	
	@GetMapping("/mostrarReserva")
	public String mostrarRerservas(Model model,Authentication auth) {
		
		String username= auth.getName();
		///System.out.println(username);
		Usuario user= serviceUsuarios.buscarPorUsername(username);
		//System.out.println(user);
		List <Libro> reservas = user.getReservas();
		//System.out.println(reservas);
		model.addAttribute("libros", reservas);
		return "catalogo/misLibros.html";
	}
}
