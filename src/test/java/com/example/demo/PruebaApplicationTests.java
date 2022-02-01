package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.modelo.Canal;
import com.example.demo.modelo.Distribuidor;
import com.example.demo.modelo.Producto;
import com.example.demo.repo.CanalRepo;
import com.example.demo.repo.DistribuidorRepo;
import com.example.demo.repo.ProductoRepo;
import com.example.demo.servicios.CanalServicios;
import com.example.demo.servicios.DisttribuidorServicios;
import com.example.demo.servicios.ProductoServicios;
@RunWith(SpringRunner.class)
@SpringBootTest
class PruebaApplicationTests {
	@Autowired
	private DisttribuidorServicios servicios;
	@Autowired
	private ProductoServicios servicios2;
	@Autowired
	private CanalServicios servicios3;
	@MockBean
	private DistribuidorRepo repositorio;
	@MockBean
	private ProductoRepo repositorio2;
	@MockBean 
	private CanalRepo repositorio3;
	@Test
	public void listarDistribuidorTest() {
		when(repositorio.findAll()).thenReturn(Stream.of(new Distribuidor(1, "Juan", "JuanNoti@prueba.org","JuanAlert@prueba.org"), new Distribuidor(2, "Pedro", "PedroNoti@prueba.org","PedroAlert@prueba.org"), new Distribuidor(3, "Daphne", "DaphneNoti@prueba.org","DaphneAlert@prueba.org")).collect(Collectors.toList()));
		assertEquals(3, servicios.listarDistribuidor().size());
	}
	@Test
	public void listarCodigoDisTest() {
		int codigo_dis = 1;
		when(repositorio.findById(codigo_dis)).thenReturn(Optional.of(new Distribuidor(1, "Juan", "JuanNoti@prueba.org","JuanAlert@prueba.org")));
		assertEquals(codigo_dis, servicios.listarCodigoDis(codigo_dis).get().getCodigo_dis());
	}
	@Test
	public void saveDisTest() {
		Distribuidor distribuidor = new Distribuidor(1, "Juan", "JuanNoti@prueba.org","JuanAlert@prueba.org");
		when(repositorio.save(distribuidor)).thenReturn(distribuidor);
		assertEquals(distribuidor, servicios.saveDistribuidor(distribuidor));
	}
	@Test
	public void deleteDisTest() {
		Distribuidor distribuidor = new Distribuidor(1, "Juan", "JuanNoti@prueba.org","JuanAlert@prueba.org");
		servicios.deleteDistribuidor(distribuidor.getCodigo_dis());
		verify(repositorio, times(1)).deleteById(distribuidor.getCodigo_dis());
	}
	@Test
	public void listarProdTest() {
		when(repositorio2.findAll()).thenReturn(Stream.of(new Producto(1, "Pescado frito", "Q. 300"), new Producto(2, "Pasta de dientes Colgate", "Q. 50"), new Producto(3, "Bicicleta azul ruedas todoterreno", "Q. 500")).collect(Collectors.toList()));
		assertEquals(3, servicios2.listarProducto().size());
	}
	@Test
	public void listarCodigoProdTest() {
		int codigo_prod = 1;
		when(repositorio2.findById(codigo_prod)).thenReturn(Optional.of(new Producto(1, "Pescado frito", "Q. 300")));
		assertEquals(codigo_prod, servicios2.listarCodigoProd(codigo_prod).get().getCodigo_prod());
	}
	@Test
	public void saveProdTest() {
		Producto producto = new Producto(1, "Pescado frito", "Q. 300");
		when(repositorio2.save(producto)).thenReturn(producto);
		assertEquals(producto, servicios2.saveProducto(producto));
	}
	@Test
	public void deleteProdTest() {
		Producto producto = new Producto(1, "Pescado frito", "Q. 300");
		servicios2.deleteProducto(producto.getCodigo_prod());
		verify(repositorio2, times(1)).deleteById(producto.getCodigo_prod());
	}
	@Test
	public void listarCanalTest() {
		when(repositorio3.findAll()).thenReturn(Stream.of(new Canal(1, "Pasito Veloz"), new Canal(2, "UPS"), new Canal(1, "DHL")).collect(Collectors.toList()));
		assertEquals(3, servicios3.listarCanal().size());
	}
	@Test
	public void listarCodigoCanalTest() {
		int codigo_canal = 1;
		when(repositorio3.findById(codigo_canal)).thenReturn(Optional.of(new Canal(1, "Pasito Veloz")));
		assertEquals(codigo_canal, servicios3.listarCodigoCanal(codigo_canal).get().getCodigo_canal());
	}
	@Test
	public void saveCanalTest() {
		Canal canal = new Canal(1, "Pasito Veloz");
		when(repositorio3.save(canal)).thenReturn(canal);
		assertEquals(canal, servicios3.saveCanal(canal));
	}
	@Test
	public void deleteCanalTest() {
		Canal canal = new Canal(1, "Pasito Veloz");
		servicios3.deleteCanal(canal.getCodigo_canal());
		verify(repositorio3, times(1)).deleteById(canal.getCodigo_canal());
	}
}
