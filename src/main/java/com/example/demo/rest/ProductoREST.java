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

import com.example.demo.interfacesService.IPService;
import com.example.demo.modelo.Producto;

@Controller
@RequestMapping
public class ProductoREST {
	@Autowired
	private IPService servicios;
	
	@GetMapping("/listarProd")
	public String listarTodosProductos(Model model) {
		List<Producto>producto=servicios.listarProducto();
		model.addAttribute("producto", producto);
		return "productos";
	}
	@GetMapping("/newProd")
	public String agregarPorducto(Model model) {
		model.addAttribute("producto", servicios.saveProducto(new Producto()));
		return "formularioProd";
	}
	@PostMapping("/saveProd")
	public String saveProducto(@Valid Producto producto, Model model) {
		servicios.saveProducto(producto);
		return "redirect:/listarProd";
	}
	@GetMapping("/editarProd/{codigo_prod}")
	public String editarProducto(@PathVariable int codigo_prod, Model model) {
		Optional<Producto> producto = servicios.listarCodigoProd(codigo_prod);
		model.addAttribute("producto", producto);
		return "formularioProd";
	}
	@GetMapping("/eliminarProd/{codigo_prod}")
	public String deleteProducto(@PathVariable int codigo_prod, Model model) {
		servicios.deleteProducto(codigo_prod);
		return "redirect:/listarProd";
	}
}
