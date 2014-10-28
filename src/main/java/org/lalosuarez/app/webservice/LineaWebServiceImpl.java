package org.lalosuarez.app.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lalosuarez.app.dto.Estacion;
import org.lalosuarez.app.dto.Linea;
import org.lalosuarez.app.service.EstacionService;
import org.lalosuarez.app.service.LineaService;
import org.springframework.stereotype.Component;

@Component
@Path("/json/lineas")
public class LineaWebServiceImpl implements LineaWebService {

	private LineaService service;
	
	private EstacionService estacionService;
	
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Linea> findAll() {
 		List<Linea> list = service.findAll();
 		
 		if (!list.isEmpty()) {
 	 		for (Linea object :  list) {
 	 			object.setEstaciones(null);
 	 		} 			
 		}
 		
		return list;
	}

	@Override
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)		
	public Linea find(@PathParam("id") int id) {
		Linea object = service.find(id);
		
		if (object != null) {
			object.setEstaciones(null);
		}
		
		return object;
	}
	
	@Override
	@GET
	@Path("/{id}/estaciones")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estacion> findEstacionesDeLaLinea(@PathParam("id") int id) {
 		List<Estacion> list = estacionService.findEstacionesByLinea(id);
 		
 		if (!list.isEmpty()) {
 	 		for (Estacion object :  list) {
 	 			object.setLineas(null);
 	 		} 			
 		}
 		
		return list;
	}	

	public LineaService getService() {
		return service;
	}

	public void setService(LineaService service) {
		this.service = service;
	}

	public EstacionService getEstacionService() {
		return estacionService;
	}

	public void setEstacionService(EstacionService estacionService) {
		this.estacionService = estacionService;
	}
}
