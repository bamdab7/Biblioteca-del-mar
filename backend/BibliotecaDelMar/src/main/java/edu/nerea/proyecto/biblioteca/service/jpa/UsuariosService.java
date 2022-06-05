package edu.nerea.proyecto.biblioteca.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nerea.proyecto.biblioteca.entity.Usuario;
import edu.nerea.proyecto.biblioteca.repository.UsuarioRepository;
import edu.nerea.proyecto.biblioteca.service.IUsuariosService;

@Service
public class UsuariosService implements IUsuariosService {

	@Autowired
	UsuarioRepository usuariosRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);

	}

	@Override
	public void eliminar(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);

	}

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		return usuariosRepo.findAll();
	}

}
