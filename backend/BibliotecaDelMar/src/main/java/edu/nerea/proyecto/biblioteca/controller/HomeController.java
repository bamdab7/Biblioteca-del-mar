package edu.nerea.proyecto.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { /*controlador de la pagina de inicio*/

	@GetMapping("/inicio")
	public String mostrarInicio() {
		return "inicio/index.html";
	}
}
