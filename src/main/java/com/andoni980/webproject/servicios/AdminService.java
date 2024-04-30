package com.andoni980.webproject.servicios;

import com.andoni980.webproject.entidades.Autor;
import com.andoni980.webproject.entidades.Libro;

public interface AdminService {

	public Libro saveLibro(Libro libro);
	public Libro updateLibro(Libro libro);
	public void deleteLibro(Long id);
	
	public Autor saveAutor(Autor autor);
	public Autor updateAutor(Autor autor);
	public void deleteAutor(Long id);
	
}
