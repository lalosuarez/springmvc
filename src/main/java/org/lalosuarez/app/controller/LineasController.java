package org.lalosuarez.app.controller;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lalosuarez.app.dto.Estacion;
import org.lalosuarez.app.dto.Linea;
import org.lalosuarez.app.service.EstacionService;
import org.lalosuarez.app.service.LineaService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LineasController extends MultiActionController {

	private LineaService service;
	
	private EstacionService estacionService;
	
	private Linea linea;
	
	private List<Linea> lineas;
	
	Map<Integer, Estacion> estaciones = new LinkedHashMap<Integer, Estacion>();
	
	public ModelAndView list(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		setLineas(service.findAll());
		
	    return new ModelAndView("lineas-list", "lineas", lineas);	 
	}
	
	public ModelAndView add(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		setLinea(new Linea());
		
		return new ModelAndView("lineas-form", "linea", linea);
	 
	}
	
	public ModelAndView edit(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		 
		String id = request.getParameter("i") != null ? request.getParameter("i") : "0";
		
		setLinea(
			service.find(Integer.parseInt(id))
		);
		
		if (linea == null)
			setLinea(new Linea());
		
		return new ModelAndView("lineas-form", "linea", linea);
		 
	}
	
	public void save(HttpServletRequest request,
		HttpServletResponse response, @ModelAttribute Linea linea) throws Exception {
		
		if (linea != null) {
			service.save(linea);
		}
		
		response.sendRedirect("list");
	}
	
	public void delete(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Linea linea) throws Exception {
			
		String id = request.getParameter("i") != null ? request.getParameter("i") : "0";
		service.delete(Integer.parseInt(id));
			
		response.sendRedirect("list");
	}	

	public ModelAndView manageEstaciones(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String idLinea = request.getParameter("i") != null ? request.getParameter("i") : "0";
		String idEstacion = request.getParameter("e") != null ? request.getParameter("e") : "0";
		String action = request.getParameter("action") != null ? request.getParameter("action") : "false";
		
		switch (action) {
		
		case "delete":
			removeEstacionFromMap(
				Integer.parseInt(idEstacion)
			);
			break;
		
		case "add":
			addEstacionToMap(
				estacionService.find(Integer.parseInt(idEstacion))
			);
			break;
			
		case "save":
			saveEstacionesToLinea(
				convertEstacionesMapToSet(estaciones)
			);
			response.sendRedirect("list");
			break;			
			
		default:
			int id = Integer.parseInt(idLinea);
			
			Linea object = service.find(id);
			
			if (object != null) {
				setLinea(object);
				loadEstacionesDeLaLinea(id);
			} else {
				response.sendRedirect("list");
			}	
		}
				
		ModelAndView mv = new ModelAndView("manage-estaciones");
		mv.addObject("linea", linea);
		mv.addObject("estaciones", estaciones);
		
		return mv;
	}
	
	private void saveEstacionesToLinea(Set<Estacion> estaciones) {
		
		if (linea != null) {
			linea.setEstaciones(estaciones);			
			service.save(linea);
		}
	}
	
	private void loadEstacionesDeLaLinea(int id) {
		
		Set<Estacion> set = new HashSet<Estacion>(
			estacionService.findEstacionesByLinea(id)
		);

		setEstaciones(
			convertEstacionesSetToMap(set)
		);		
	}
	
	private void addEstacionToMap(Estacion object) {
		if (object != null)
			estaciones.put(object.getId(), object);
	}
	
	private void removeEstacionFromMap(int id) {
		estaciones.remove(id);
	}
	
	private Map<Integer, Estacion> convertEstacionesSetToMap(Set<Estacion> estaciones) {
		
		Map<Integer, Estacion> map = new LinkedHashMap<Integer, Estacion>();
		
		for (Estacion object : estaciones) {
			map.put(object.getId(), object);
		}
		
		return map;
	}
	
	private Set<Estacion> convertEstacionesMapToSet(Map<Integer, Estacion> estaciones) {
		
		Set<Estacion> set = new HashSet<Estacion>();
		
		for (Estacion object : estaciones.values()) {
			set.add(object);
		}
		
		return set;
	}	

	public LineaService getService() {
		return service;
	}

	public EstacionService getEstacionService() {
		return estacionService;
	}

	public void setEstacionService(EstacionService estacionService) {
		this.estacionService = estacionService;
	}

	public void setService(LineaService service) {
		this.service = service;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public List<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas;
	}

	public Map<Integer, Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(Map<Integer, Estacion> estaciones) {
		this.estaciones = estaciones;
	}	
}
