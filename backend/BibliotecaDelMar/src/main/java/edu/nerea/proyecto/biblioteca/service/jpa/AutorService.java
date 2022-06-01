package edu.nerea.proyecto.biblioteca.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nerea.proyecto.biblioteca.entity.Autor;
import edu.nerea.proyecto.biblioteca.repository.AutorRepository;
import edu.nerea.proyecto.biblioteca.service.IAutorService;

@Service
public class AutorService implements IAutorService{

    @Autowired
    private AutorRepository repoAutores;

    @Override
    public List<Autor> buscarTodosAutores() {
        return repoAutores.findAll();
    }

    @Override
    public void guardarAutor(Autor autor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Autor buscarPorId(Integer idAutor) {
        Optional<Autor> optional= repoAutores.findById(idAutor);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void eliminarAutor(Integer idAutor) {
       repoAutores.deleteById(idAutor);
        
    }
    
}
