package com.andoni980.webproject.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.andoni980.webproject.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
