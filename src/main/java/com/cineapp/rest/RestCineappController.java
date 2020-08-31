package com.cineapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineapp.model.Usuario;
import com.cineapp.repo.IUsuarioRepo;

@RestController
@RequestMapping("/listaUsuarios")
public class RestCineappController {
	
	@Autowired 
	private IUsuarioRepo repo;
	
	@GetMapping
	public List<Usuario> listaUsuarios(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insertarUsuario(@RequestBody Usuario usu){
		repo.save(usu);
	}
	
	@PutMapping
	public void modificarUsuario(@RequestBody Usuario usu){
		repo.save(usu);
	}
	
	@DeleteMapping(value="/{id}")
	public void borrarUsuario(@PathVariable("id") Integer id){
		repo.deleteById(id);
	}
}
