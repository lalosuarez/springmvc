package org.lalosuarez.app.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.lalosuarez.app.dto.Estacion;
import org.lalosuarez.app.dto.Linea;
import org.lalosuarez.app.service.EstacionService;
import org.lalosuarez.app.service.LineaService;


@WebService(
	name="LineaService",
	targetNamespace="http://www.webservice.redmetro.lalosuarez.org",
	portName="LineaServicePort",
	serviceName="LineaWebService"
)
public class LineaSoapWebServiceImpl implements LineaWebService {

	private LineaService service;
	
	private EstacionService estacionService;
	
	
	@Override
	@WebMethod(action="find-lineas", operationName="findAll")
	@WebResult(name="Linea")
	public List<Linea> findAll() {
		List<Linea> list = service.findAll();
		
		if (!list.isEmpty()) {
			for (Linea object : list) {
				object.setEstaciones(null);
			}
		}
		
		return list;
	}

	@Override
	@WebMethod(action="find-linea", operationName="find")
	@WebResult(name="Linea")	
	public Linea find(int id) {
		Linea object = service.find(id);
		
		if (object != null) {
			object.setEstaciones(null);
		}
		
		return object;
	}

	@Override
	@WebMethod(action="find-estaciones-linea", operationName="findEstacionesDeLaLinea")
	@WebResult(name="Estacion")	
	public List<Estacion> findEstacionesDeLaLinea(int id) {
		List<Estacion> list = estacionService.findEstacionesByLinea(id);
		
		if (!list.isEmpty()) {
			for (Estacion object : list) {
				object.setLineas(null);
			}
		}
		
		return list;
	}

	@WebMethod(exclude=true)
	public LineaService getService() {
		return service;
	}
	
	@WebMethod(exclude=true)
	public void setService(LineaService service) {
		this.service = service;
	}

	@WebMethod(exclude=true)
	public EstacionService getEstacionService() {
		return estacionService;
	}

	@WebMethod(exclude=true)
	public void setEstacionService(EstacionService estacionService) {
		this.estacionService = estacionService;
	}

}
