package com.api.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.app.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

//	@Query("select u from Usuario u where u.email =?")
	Optional<Usuario> findByEmail(String email);

}
