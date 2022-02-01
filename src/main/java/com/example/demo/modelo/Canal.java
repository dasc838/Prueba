package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Canal")
public class Canal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_canal;
	
	private String nombre_canal;
	
	public Canal() {
	}

	public Canal(int codigo_canal, String nombre_canal) {
		this.codigo_canal = codigo_canal;
		this.nombre_canal = nombre_canal;
	}

	public int getCodigo_canal() {
		return codigo_canal;
	}

	public void setCodigo_canal(int codigo_canal) {
		this.codigo_canal = codigo_canal;
	}

	public String getNombre_canal() {
		return nombre_canal;
	}

	public void setNombre_canal(String nombre_canal) {
		this.nombre_canal = nombre_canal;
	}

	@Override
	public String toString() {
		return "Canal [codigo_canal=" + codigo_canal + ", nombre_canal=" + nombre_canal + "]";
	}
	
}
