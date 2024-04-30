package com.andoni980.webproject.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.andoni980.webproject.entidades.Autor;
import com.andoni980.webproject.entidades.Libro;
import com.andoni980.webproject.repositorios.AutorRepository;
import com.andoni980.webproject.repositorios.LibroRepository;

@Service
@Primary
public class AdminServiceImp extends UsuarioServiceImp implements AdminService {

	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired AutorRepository autorRepository;
	
	@Override
	public Libro saveLibro(Libro libro) {
		return libroRepository.save(libro);
	}

	@Override
	public Libro updateLibro(Libro libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}

	@Override
	public void deleteLibro(Long id) {
		libroRepository.deleteById(id);		
	}

	@Override
	public Autor saveAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public Autor updateAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public void deleteAutor(Long id) {
		autorRepository.deleteById(id);
		
	}

}
