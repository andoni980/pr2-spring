package com.andoni980.webproject.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andoni980.webproject.entidades.Libro;
import com.andoni980.webproject.servicios.AdminService;
import com.andoni980.webproject.servicios.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public String getAllLibros(Model modelo) {
		modelo.addAttribute("libros", usuarioService.getAllLibros());
		return "index";
	}
	
	@GetMapping("/{id}")
	public String getLibroById(@PathVariable("id") Long id, Model modelo) {
		modelo.addAttribute("libro", usuarioService.getLibroById(id));
		return "detalle-libro";
	}
	
	@GetMapping("admin")
	public String adminLibro(Libro libro, Model modelo) {
		modelo.addAttribute("libros", usuarioService.getAllLibros());
		modelo.addAttribute("autores", usuarioService.getAllAutores());
		libro.setId(null);
		return "admin";
	}
	
	@PostMapping("admin")
	public String adminSaveLibro(@Valid Libro libro, Model modelo, BindingResult bindingResult) {
		
		System.out.println("error");
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			modelo.addAttribute("libros", usuarioService.getAllLibros());
//			modelo.addAttribute("autores", usuarioService.getAllAutores());
			return "admin";
		}
		
		adminService.saveLibro(libro);
		
		return "redirect:/admin";
	}
	
	@GetMapping("admin/{id}")
	public String adminUpdateLibro(Model modelo, @PathVariable("id") Long id) {
		modelo.addAttribute("libros", usuarioService.getAllLibros());
		Libro libro = usuarioService.getLibroById(id);
		modelo.addAttribute("libro", libro);
		modelo.addAttribute("autores", usuarioService.getAllAutores());
		return "admin";
	}
	
	@PostMapping("admin/{id}")
	public String updateLibro(@Valid Libro libro, BindingResult bindingResult, Model modelo) {
		modelo.addAttribute("autores", usuarioService.getAllAutores());
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("libros", usuarioService.getAllLibros());
			return "admin";
		}
		adminService.updateLibro(libro);
		
		return "redirect:/admin";
	}
	
	@GetMapping("admin/borrar/{id}")
	public String deleteLibro(@PathVariable("id") Long id) {
		adminService.deleteLibro(id);
		return "redirect:/admin";
	}
	
	
	@GetMapping("autores")
	public String getAllAutores(Model modelo) {
		modelo.addAttribute("autores", usuarioService.getAllAutores());
		return "autores";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("logout")
	public String logout() {
		return "logout";
	}

}
