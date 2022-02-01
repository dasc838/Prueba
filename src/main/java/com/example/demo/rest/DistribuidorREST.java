package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.*;
import com.example.demo.interfacesService.IDService;
import com.example.demo.modelo.Distribuidor;


@Controller
@RequestMapping
public class DistribuidorREST {
	@Autowired
	private IDService servicios;
	
	@GetMapping("/listarDis")
	public String listarTodosDistribuidores(Model model) {
		List<Distribuidor>distribuidor=servicios.listarDistribuidor();
		model.addAttribute("distribuidor", distribuidor);
		return "distribuidores";
	}
	@GetMapping("/newDis")
	public String agregarDistribuidor(Model model) {
		model.addAttribute("distribuidor", servicios.saveDistribuidor(new Distribuidor()));
		return "formularioDis";
	}
	@PostMapping("/saveDis")
	public String saveDistribuidor(@Valid Distribuidor distribuidor, Model model) {
		servicios.saveDistribuidor(distribuidor);
		return "redirect:/listarDis";
	}
	@GetMapping("/editarDis/{codigo_dis}")
	public String editarDistribuidor(@PathVariable int codigo_dis, Model model) {
		Optional<Distribuidor> distribuidor = servicios.listarCodigoDis(codigo_dis);
		model.addAttribute("distribuidor", distribuidor);
		return "formularioDis";
	}
	@GetMapping("/eliminarDis/{codigo_dis}")
	public String deleteDistribuidor(@PathVariable int codigo_dis, Model model) {
		servicios.deleteDistribuidor(codigo_dis);
		return "redirect:/listarDis";
	}
}
