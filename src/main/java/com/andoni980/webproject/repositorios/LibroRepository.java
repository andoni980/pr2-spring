package com.andoni980.webproject.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.andoni980.webproject.entidades.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {

}
