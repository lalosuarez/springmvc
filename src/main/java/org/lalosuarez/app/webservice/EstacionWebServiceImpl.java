package org.lalosuarez.app.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lalosuarez.app.dto.Estacion;
import org.lalosuarez.app.service.EstacionService;
import org.springframework.stereotype.Component;

@Component
@Path("/json/estaciones")
public class EstacionWebServiceImpl implements EstacionWebService {
	
	private EstacionService service;
	
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estacion> findAll() {
 		List<Estacion> list = service.findAll();
 		
 		if (!list.isEmpty()) {
 	 		for (Estacion object :  list) {
 	 			object.setLineas(null);
 	 		} 			
 		}
 		
		return list;
	}

	@Override
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Estacion find(@PathParam("id") int id) {
		Estacion object = service.find(id);
		
		if (object != null) {
			object.setLineas(null);
		}
		
		return object;
	}

	public EstacionService getService() {
		return service;
	}

	public void setService(EstacionService service) {
		this.service = service;
	}

}
