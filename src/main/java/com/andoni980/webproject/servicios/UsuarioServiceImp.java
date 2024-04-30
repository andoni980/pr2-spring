package com.andoni980.webproject.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andoni980.webproject.entidades.Autor;
import com.andoni980.webproject.entidades.Libro;
import com.andoni980.webproject.repositorios.AutorRepository;
import com.andoni980.webproject.repositorios.LibroRepository;

@Service
public class UsuarioServiceImp implements UsuarioService{
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public Iterable<Libro> getAllLibros() {
		return libroRepository.findAll();
	}

	@Override
	public Libro getLibroById(Long id) {
		return libroRepository.findById(id).get();
	}

	@Override
	public Iterable<Autor> getAllAutores() {
		return autorRepository.findAll();
	}

	@Override
	public Autor getAutorById(Long id) {
		return autorRepository.findById(id).get();
	}

}
