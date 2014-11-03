package org.lalosuarez.app.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.lalosuarez.app.dto.Estacion;
import org.lalosuarez.app.service.EstacionService;

@WebService(
	name="EstacionService",
	targetNamespace="http://www.webservice.redmetro.lalosuarez.org",
	portName="EstacionServicePort",
	serviceName="EstacionWebService"
)
public class EstacionSoapWebServiceImpl implements EstacionWebService {

	private EstacionService estacionService;
	
	@Override
	@WebMethod(action="find-estaciones", operationName="findAll")
	@WebResult(name="Estacion2")	
	public List<Estacion> findAll() {
		List<Estacion> list = estacionService.findAll();
		
		if (!list.isEmpty()) {
			for (Estacion object : list) {
				object.setLineas(null);
			}
		}
		
		return list;
	}

	@Override
	@WebMethod(action="find-estacion", operationName="find")
	@WebResult(name="Estacion2")	
	public Estacion find(int id) {
		Estacion object = estacionService.find(id);
		
		if (object != null) {
			object.setLineas(null);
		}
		
		return object;
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
