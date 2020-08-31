package com.cineapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineapp.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findByUsuario(String usuario);
}
