package edu.nerea.proyecto.biblioteca.service;

import java.util.List;

import edu.nerea.proyecto.biblioteca.entity.Editorial;

public interface IEditorialService {
	//en esta clase listaremos los diferentes metodos/consultas que hacen referencia a nuestra tabla editorial
	List<Editorial> buscarTodasEditoriales();
}
