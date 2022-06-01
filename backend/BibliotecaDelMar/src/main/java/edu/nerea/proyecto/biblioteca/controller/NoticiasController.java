package edu.nerea.proyecto.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NoticiasController {

	@GetMapping("/noticias")
	public String mostrarNoticias() {
		return "noticias/gruponoticias.html";
	}
	@GetMapping("/noticia1")
	public String mostrarNoticia1() {
		return "noticias/noticia1.html";
	}
	@GetMapping("/noticia2")
	public String mostrarNoticia2() {
		return "noticias/noticia2.html";
	}
	@GetMapping("/noticia3")
	public String mostrarNoticia3() {
		return "noticias/noticia3.html";
	}
	@GetMapping("/noticia4")
	public String mostrarNoticia4() {
		return "noticias/noticia4.html";
	}
	@GetMapping("/noticia5")
	public String mostrarNoticia5() {
		return "noticias/noticia5.html";
	}
}
