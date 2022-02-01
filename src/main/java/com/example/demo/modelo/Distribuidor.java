package com.example.demo.modelo;

import javax.persistence.*;

@Entity
@Table (name = "Distribuidor")
public class Distribuidor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_dis;
	
	private String nombre_dis;
	private String correo_notificacion;
	private String correo_alert;
	
	
	public Distribuidor() {
	}


	public Distribuidor(int codigo_dis, String nombre_dis, String correo_notificacion, String correo_alert) {
		this.codigo_dis = codigo_dis;
		this.nombre_dis = nombre_dis;
		this.correo_notificacion = correo_notificacion;
		this.correo_alert = correo_alert;
	}
	
	
	public int getCodigo_dis() {
		return codigo_dis;
	}
	public void setCodigo_dis(int codigo_dis) {
		this.codigo_dis = codigo_dis;
	}
	public String getNombre_dis() {
		return nombre_dis;
	}
	public void setNombre_dis(String nombre_dis) {
		this.nombre_dis = nombre_dis;
	}
	public String getCorreo_notificacion() {
		return correo_notificacion;
	}
	public void setCorreo_notificacion(String correo_notificacion) {
		this.correo_notificacion = correo_notificacion;
	}
	public String getCorreo_alert() {
		return correo_alert;
	}
	public void setCorreo_alert(String correo_alert) {
		this.correo_alert = correo_alert;
	}


	@Override
	public String toString() {
		return "Distribuidor [codigo_dis=" + codigo_dis + ", nombre_dis=" + nombre_dis + ", correo_notificacion="
				+ correo_notificacion + ", correo_alert=" + correo_alert + "]";
	}
	
}
