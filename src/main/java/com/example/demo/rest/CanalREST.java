package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfacesService.ICService;
import com.example.demo.modelo.Canal;

@Controller
@RequestMapping
public class CanalREST {
	@Autowired
	private ICService servicios;
	@GetMapping("/listarCanal")
	public String listarTodosCanales(Model model) {
		List<Canal>canal=servicios.listarCanal();
		model.addAttribute("canal", canal);
		return "canales";
	}
	@GetMapping("/newCanal")
	public String agregarCanal(Model model) {
		model.addAttribute("canal", servicios.saveCanal(new Canal()));
		return "formularioCanal";
	}
	@PostMapping("/saveCanal")
	public String saveCanal(@Valid Canal canal, Model model) {
		servicios.saveCanal(canal);
		return "redirect:/listarCanal";
	}
	@GetMapping("/editarCanal/{codigo_canal}")
	public String editarCanal(@PathVariable int codigo_canal, Model model) {
		Optional<Canal> canal = servicios.listarCodigoCanal(codigo_canal);
		model.addAttribute("canal", canal);
		return "formularioCanal";
	}
	@GetMapping("/eliminarCanal/{codigo_canal}")
	public String deleteCanal(@PathVariable int codigo_canal, Model model) {
		servicios.deleteCanal(codigo_canal);
		return "redirect:/listarCanal";
	}
}
