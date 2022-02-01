package com.example.demo.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Producto;

public interface IPService {
	public List<Producto>listarProducto();
	public Optional<Producto>listarCodigoProd(int codigo_prod);
	public Producto saveProducto(Producto producto);
	public void deleteProducto(int codigo_prod);
}
