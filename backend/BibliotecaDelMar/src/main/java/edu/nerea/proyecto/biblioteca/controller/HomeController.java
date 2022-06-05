package edu.nerea.proyecto.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.nerea.proyecto.biblioteca.entity.Perfil;
import edu.nerea.proyecto.biblioteca.entity.Usuario;
import edu.nerea.proyecto.biblioteca.service.IUsuariosService;

@Controller
public class HomeController { /*controlador de la pagina de inicio*/

	@Autowired
	private IUsuariosService serviceUsuarios;
	
	
	@GetMapping("/")
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
	
	//USUARIOS
	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "forms/registroUsuario.html";
	}
	@PostMapping("/signup")
	public String guardarResgistro(Usuario usuario, RedirectAttributes attributes) {
			//cuando registremos un usuario le asignaremos un estado por defecto junto con un permiso
		usuario.setStatus(1); //por defecto cada usuario registrado estará activo
		Perfil perfil =new Perfil();
		perfil.setId(2); //le assignamos un perfil de usuario
		usuario.agregar(perfil);
		
		serviceUsuarios.guardar(usuario);
		
		return "redirect:/"; //nos redirige directamente a la ventana de inicio cuando nos iniciamos
	}
}
