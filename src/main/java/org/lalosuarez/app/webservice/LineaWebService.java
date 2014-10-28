package org.lalosuarez.app.webservice;

import java.util.List;

import javax.ws.rs.PathParam;

import org.lalosuarez.app.dto.Estacion;
import org.lalosuarez.app.dto.Linea;

public interface LineaWebService {
	
	public List<Linea> findAll();
	
	public Linea find(@PathParam("id") int id);
	
	public List<Estacion> findEstacionesDeLaLinea(@PathParam("id") int id);
		
}
