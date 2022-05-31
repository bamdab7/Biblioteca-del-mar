package edu.nerea.proyecto.biblioteca.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nerea.proyecto.biblioteca.entity.Editorial;
import edu.nerea.proyecto.biblioteca.repository.EditorialRepository;
import edu.nerea.proyecto.biblioteca.service.IEditorialService;

@Service
public class EditorialService implements IEditorialService {

	@Autowired
	private EditorialRepository repoEditorial;
	
	@Override
	public List<Editorial> buscarTodasEditoriales() {
		return repoEditorial.findAll();
	}

}
