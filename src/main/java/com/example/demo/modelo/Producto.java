package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_prod;
	
	private String descripcion;
	private String monto;
	
	
	public Producto() {
	}


	public Producto(int codigo_producto, String descripcion, String monto) {
		this.codigo_prod = codigo_producto;
		this.descripcion = descripcion;
		this.monto = monto;
	}


	public int getCodigo_prod() {
		return codigo_prod;
	}


	public void setCodigo_prod(int codigo_producto) {
		this.codigo_prod = codigo_producto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getMonto() {
		return monto;
	}


	public void setMonto(String monto) {
		this.monto = monto;
	}


	@Override
	public String toString() {
		return "Producto [codigo_prod=" + codigo_prod + ", descripcion=" + descripcion + ", monto=" + monto + "]";
	}
	
	
}
