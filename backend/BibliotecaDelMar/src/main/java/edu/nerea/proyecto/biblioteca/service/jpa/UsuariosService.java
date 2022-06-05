package edu.nerea.proyecto.biblioteca.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nerea.proyecto.biblioteca.entity.Libro;
import edu.nerea.proyecto.biblioteca.entity.Usuario;
import edu.nerea.proyecto.biblioteca.repository.LibroRepository;
import edu.nerea.proyecto.biblioteca.repository.UsuarioRepository;
import edu.nerea.proyecto.biblioteca.service.IUsuariosService;

@Service
public class UsuariosService implements IUsuariosService {

	@Autowired
	UsuarioRepository usuariosRepo;
	@Autowired
	LibroRepository librosRepo;
	
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

	@Override
	public void addReservas(String username, Integer idLibro) {
		Usuario user = usuariosRepo.findByUsername(username);
		Libro libro = librosRepo.getById(idLibro);
		System.out.print(user);
		System.out.print(libro);
		user.getReservas().add(libro);
		
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		return usuariosRepo.findByUsername(username);
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		Optional<Usuario> optional = usuariosRepo.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


}
