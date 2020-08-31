package com.cineapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineapp.model.Usuario;
import com.cineapp.repo.IUsuarioRepo;

@Controller
public class CineappController {
	
	@Autowired
	private IUsuarioRepo repo;
	
	@GetMapping("/usuario")
	public String usuario(@RequestParam(name="usuario", required=false, defaultValue="User") String user, 
						  @RequestParam(name="password", required=false, defaultValue="1234") String password, 
						  Model model) {
		
		Usuario u = new Usuario();
		u.setId(2);
		u.setUsuario("User1");
		u.setPassword("4321");
		repo.save(u);
		
		model.addAttribute("usuario", user);
		return "usuario";
	}
	
	@GetMapping("/listar")
	public String listaUsuarios(Model model) {
		model.addAttribute("usuarios", repo.findAll()); 
		return "listar";
	}
}
