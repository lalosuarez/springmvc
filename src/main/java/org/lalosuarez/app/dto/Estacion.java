package org.lalosuarez.app.dto;

import java.util.HashSet;
import java.util.Set;


public class Estacion {
	
	private int id;
	
	private String nombre;
	
	private String tipo;
	
	private Set<Linea> lineas = new HashSet<Linea>();

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(Set<Linea> lineas) {
		this.lineas = lineas;
	}	
}
