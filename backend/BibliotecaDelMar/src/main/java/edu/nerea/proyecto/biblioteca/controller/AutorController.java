package edu.nerea.proyecto.biblioteca.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.web.multipart.MultipartFile;
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
    public String editAutor(@PathVariable("id") Integer idAutor, Model model){
        Autor autor= serviceAutor.buscarPorId(idAutor);
        model.addAttribute("autor", autor);
        return "forms/addAutor.html";
    }
    @PostMapping("/saveAutor") //BindingResult para capturar los errores de conversion del formulario
	public String crearAutor(Autor autor,BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile imagen)throws IOException{
    	
		if(result.hasErrors()){
			for(ObjectError error : result.getAllErrors()){
				System.out.println("Error: " + error.getDefaultMessage());
			} //nos informa que error se esta cometiendo y nos devuelve al formulario			
			return "forms/addAutor.html";
		}
		InputStream initialStream = imagen.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File file = new File("src/main/resources/static/img/" + autor.getNombre() + ".jpg"); //guardamos la imagen

        try (OutputStream outStream = new FileOutputStream(file)) {
            outStream.write(buffer);
        }
        autor.setImagen(autor.getNombre()+ ".jpg");
		serviceAutor.guardarAutor(autor);
		attributes.addFlashAttribute ("msg", "Se ha guardado el autor");
		return "redirect:/autores";
	}
    @GetMapping("/createAutor")
    public String crearAutor(Autor autor){
        return "forms/addAutor.html";
    }



        //metodo eliminar autor
    @GetMapping("/eliminarAutor/{id}")
    public String eliminar(@PathVariable("id") Integer idAutor, RedirectAttributes attributes){
        serviceAutor.eliminarAutor(idAutor);
        attributes.addFlashAttribute("msg", "El autor fue eliminado");
        return "redirect:/autores";
    }

}
