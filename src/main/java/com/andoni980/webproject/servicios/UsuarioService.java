package com.andoni980.webproject.servicios;

import com.andoni980.webproject.entidades.Autor;
import com.andoni980.webproject.entidades.Libro;

public interface UsuarioService {

	public Iterable<Libro> getAllLibros();
	public Libro getLibroById(Long id);
	
	public Iterable<Autor> getAllAutores();
	public Autor getAutorById(Long id);
	
	
}
