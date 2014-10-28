package org.lalosuarez.app.webservice;

import java.util.List;

import javax.ws.rs.PathParam;

import org.lalosuarez.app.dto.Estacion;

public interface EstacionWebService {
	public List<Estacion> findAll();
	
	public Estacion find(@PathParam("id") int id);
	
}
