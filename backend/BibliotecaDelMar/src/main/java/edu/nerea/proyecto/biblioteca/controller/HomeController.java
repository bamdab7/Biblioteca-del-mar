package edu.nerea.proyecto.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { /*controlador de la pagina de inicio*/

	@GetMapping("/inicio")
	public String mostrarInicio() {
		return "inicio/index.html";
	}
	@GetMapping("/actividad1")
	public String mostrarActividad1() {
		return "actividades/actividad1.html";
	}
	@GetMapping("/actividad2")
	public String mostrarActividad2() {
		return "actividades/actividad2.html";
	}
	@GetMapping("/actividad3")
	public String mostrarActividad3() {
		return "actividades/actividad3.html";
	}
}
