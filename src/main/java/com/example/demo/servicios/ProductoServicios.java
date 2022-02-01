package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfacesService.IPService;
import com.example.demo.modelo.Producto;
import com.example.demo.repo.ProductoRepo;

@Service
public class ProductoServicios implements IPService {
	@Autowired
	private ProductoRepo datos;
	@Override
	public List<Producto> listarProducto() {
		return (List<Producto>)datos.findAll();
	}

	@Override
	public Optional<Producto> listarCodigoProd(int codigo_prod) {
		return datos.findById(codigo_prod);
	}

	@Override
	public Producto saveProducto(Producto producto) {
		datos.save(producto);
		return producto;
	}

	@Override
	public void deleteProducto(int codigo_prod) {
		datos.deleteById(codigo_prod);
		
	}

}
