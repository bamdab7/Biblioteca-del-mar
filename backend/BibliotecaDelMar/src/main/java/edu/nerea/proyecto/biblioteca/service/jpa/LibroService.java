package edu.nerea.proyecto.biblioteca.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nerea.proyecto.biblioteca.entity.Libro;
import edu.nerea.proyecto.biblioteca.repository.LibroRepository;
import edu.nerea.proyecto.biblioteca.service.ILibroService;

@Service
public class LibroService implements ILibroService {

	@Autowired
	private LibroRepository repoLibros;
	
	//metodo que busca todos los libros sin ningun filtro
	@Override
	public List<Libro> buscarTodosLibros() {
		return repoLibros.findAll();
	}
	//metodo que guarda el libro (solo disponible para administradores)
	@Override
	public void guardarLibro(Libro libro) {
		repoLibros.save(libro);
	}

	//metodo que busca por el id del libro y devuelve un 'objeto'
	@Override
	public Libro buscarPorId(Integer idLibro) {
		Optional<Libro> optional = repoLibros.findById(idLibro);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	//metodo que elimina los libros (solo disponible para administradores)
	@Override
	public void eliminar(Integer idLibro) {
		repoLibros.deleteById(idLibro); //método predefinido
		
	}
	

}
