package edu.nerea.proyecto.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FAController {

	@GetMapping("/FA")
	public String mostrarFA() {
		return "fa/FA.html";
	}
}
