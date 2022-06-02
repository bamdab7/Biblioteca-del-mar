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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.nerea.proyecto.biblioteca.entity.Autor;
import edu.nerea.proyecto.biblioteca.service.IAutorService;

@Controller
public class AutorController {
    
    @Autowired
    private IAutorService serviceAutor;

        //metodo q nos listará a todos los autores en una tabla y en la seccion de detalle de libro
    @GetMapping("/autores")
    public String mostrarAutores(Model model){
        List<Autor> lista= serviceAutor.buscarTodosAutores();
        model.addAttribute("autores",lista);
        return "autores/listAutores.html";
    }
    @GetMapping("/editAutor/{id}")
    public String editAutor(@PathVariable("id") int idAutor, Model model){
        Autor autor= serviceAutor.buscarPorId(idAutor);
        model.addAttribute("autor", autor);
        return "forms/addAutor.html";
    }
    @PostMapping("/saveAutor") //BindingResult para capturar los errores de conversion del formulario
	public String crearAutor(Autor autor,BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			for(ObjectError error : result.getAllErrors()){
				System.out.println("Error: " + error.getDefaultMessage());
			} //nos informa que error se esta cometiendo y nos devuelve al formulario
			return "autores/listAutores.html";
		}

		serviceAutor.guardarAutor(autor);
		attributes.addFlashAttribute ("msg", "Se ha guardado el autor");
		return "catalogo/productos.html";
	}
    @GetMapping("/createAutor")
    public String crearAutor(Autor autor){
        return "forms/addAutor.html";
    }

    ///saveAutor


        //metodo eliminar autor
    @GetMapping("/eliminarAutor/{id}")
    public String eliminar(@PathVariable("id") int idAutor, RedirectAttributes attributes){
        serviceAutor.eliminarAutor(idAutor);
        attributes.addFlashAttribute("msg", "El autor fue eliminado");
        return null;
    }

}
