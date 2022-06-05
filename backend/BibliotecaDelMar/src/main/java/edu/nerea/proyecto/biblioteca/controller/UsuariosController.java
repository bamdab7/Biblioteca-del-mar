package edu.nerea.proyecto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.nerea.proyecto.biblioteca.entity.Usuario;
import edu.nerea.proyecto.biblioteca.service.IUsuariosService;

@Controller
public class UsuariosController {

		@Autowired
		private IUsuariosService serviceUsuarios;
		
		@GetMapping("/usuarios")
		public String mostrarUsuarios(Model model) {
			List<Usuario> lista= serviceUsuarios.buscarTodosUsuarios();
			model.addAttribute("usuarios", lista);
			return "listuser/listuser.html";
		}
		@GetMapping("/deleteuser/{id}")
		public String eliminarUsuarios(@PathVariable("id") Integer idUsuario) {
			serviceUsuarios.eliminar(idUsuario);
			return "redirect:/usuarios";
		}
		
}

