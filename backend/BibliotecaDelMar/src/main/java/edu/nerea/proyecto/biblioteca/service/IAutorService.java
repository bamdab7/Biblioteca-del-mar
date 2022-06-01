package edu.nerea.proyecto.biblioteca.service;

import java.util.List;

import edu.nerea.proyecto.biblioteca.entity.Autor;

public interface IAutorService {
    //declaracion de los metodos que hacen referencia a autores
    List<Autor> buscarTodosAutores();
    void guardarAutor(Autor autor);
    Autor buscarPorId(Integer idAutor);
    void eliminarAutor(Integer idAutor);
    //editar autor

}
