package edu.nerea.proyecto.biblioteca.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nerea.proyecto.biblioteca.entity.Libro;
import edu.nerea.proyecto.biblioteca.repository.LibroRepository;
import edu.nerea.proyecto.biblioteca.service.ILibroService;

@Service
public class LibroService implements ILibroService {

	@Autowired
	private LibroRepository repoLibros;
	
	@Override
	public List<Libro> buscarTodosLibros() {
		return repoLibros.findAll();
	}

}
