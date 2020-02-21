package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@Controller
public class IndexController {
	
	@Autowired
	private IClienteService clienteService;	

	@GetMapping(value = {"/", "/login"})
	public String index(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "login";
	}
	
	@PostMapping(value = {"/", "/login"})
	public String indexx(HttpServletRequest request, Map<String, Object> model, RedirectAttributes flash) {
		String euser = request.getParameter("euser");
		String password = request.getParameter("password");
		Cliente cli = clienteService.findByNombreAndPassword(euser, password);
		if(cli == null) {
			flash.addFlashAttribute("error", "El cliente no registrado");
			return "redirect:/login";
		}
		model.put("cliente", cli);
		return "index";
	}
}
