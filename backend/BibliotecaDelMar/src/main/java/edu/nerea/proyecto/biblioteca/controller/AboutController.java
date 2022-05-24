package edu.nerea.proyecto.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

	@GetMapping("/aboutus")
	public String mostrarNoticias() {
		return "historia/sobrebiblioteca.html";
	}
}
