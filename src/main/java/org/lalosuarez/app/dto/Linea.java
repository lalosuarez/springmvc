package org.lalosuarez.app.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Linea {

	@Id
	private int id;
	
	private String nombre;
	
	private String color;

	private Set<Estacion> estaciones = new HashSet<Estacion>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(Set<Estacion> estaciones) {
		this.estaciones = estaciones;
	}
}
