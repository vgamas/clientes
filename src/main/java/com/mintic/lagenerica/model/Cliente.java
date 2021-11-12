package com.mintic.lagenerica.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_clientes")
public class Cliente {

	@Id
	private Long cedula_cliente;
	//@DBRef
	private String nombre_cliente;
	private String direccion_cliente;
	private Double telefono_cliente;
	private String correo_cliente;

	public Long getCedula_cliente() {
		return cedula_cliente;
	}
	
	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	
	public Double getTelefono_cliente() {
		return telefono_cliente;
	}
	
	public void setTelefono_cliente(Double telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	
	public String getCorreo_cliente() {
		return correo_cliente;
	}
	
	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}
		
}

