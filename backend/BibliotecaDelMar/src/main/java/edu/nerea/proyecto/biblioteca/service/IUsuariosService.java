package edu.nerea.proyecto.biblioteca.service;

import java.util.List;

import edu.nerea.proyecto.biblioteca.entity.Usuario;

public interface IUsuariosService {

	//intefaz para los usuarios
	void guardar(Usuario usuario);
	void eliminar (Integer idUsuario);
	Usuario buscarPorId(Integer idUsuario);
	List<Usuario> buscarTodosUsuarios();
	void addReservas(String username, Integer idLibro);
	Usuario buscarPorUsername(String username);
}
