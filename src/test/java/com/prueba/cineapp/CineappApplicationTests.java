package com.prueba.cineapp;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cineapp.model.Usuario;
import com.cineapp.repo.IUsuarioRepo;

public class CineappApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() throws Exception{
		Usuario us = new Usuario();
		us.setId(4);
		us.setUsuario("prueba1");
		us.setPassword(encoder.encode("0000"));
		Usuario retorno = repo.save(us);
		
		assertEquals(retorno.getId(), us.getId());
		assertEquals(retorno.getUsuario(), us.getUsuario());
		assertEquals(retorno.getPassword(), us.getPassword());
		//assertTrue(retorno.getId() == us.getId());
		//assertTrue(retorno.getUsuario().equalsIgnoreCase(us.getUsuario()));
		//assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
