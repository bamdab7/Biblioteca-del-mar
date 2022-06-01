package edu.nerea.proyecto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.nerea.proyecto.biblioteca.entity.Autor;
import edu.nerea.proyecto.biblioteca.service.IAutorService;

@Controller
public class AutorController {
    
    @Autowired
    private IAutorService serviceAutor;

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

}
