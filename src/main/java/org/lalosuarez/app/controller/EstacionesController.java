package org.lalosuarez.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lalosuarez.app.dto.Estacion;
import org.lalosuarez.app.dto.Linea;
import org.lalosuarez.app.service.EstacionService;
import org.lalosuarez.util.paginator.Paginator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EstacionesController extends MultiActionController {

	private EstacionService service;
	
	private Estacion estacion;
	
	private List<Estacion> estaciones;
	
	private Paginator paginator;
	
	private ModelAndView view;
		
	@SuppressWarnings("unchecked")
	public ModelAndView list(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		int page = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "1");
		
		setEstaciones(service.findAll());
		
		paginator.setNumberOfElementsToShow(5);
		
		List<Integer> paginationItems = paginator.createPaginationItems(estaciones.size());
		
		List<Estacion> paginatedResults = paginator.paginate(estaciones, page);
						
		view.setViewName("estacionesList");
		view.addObject("estaciones", paginatedResults);
		view.addObject("paginationItems", paginationItems);
		view.addObject("page", page);
		
	    return view;	 
	}
		
	public ModelAndView add(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		setEstacion(new Estacion());
		
		view.setViewName("estacionesForm");
		view.addObject("estacion", estacion);
		
		return view;
	 
	}
	
	public ModelAndView edit(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		 
		String id = request.getParameter("i") != null ? request.getParameter("i") : "0";
				
		setEstacion(
			service.find(Integer.parseInt(id))
		);
		
		if (estacion == null )
			setEstacion(new Estacion());
		
		view.setViewName("estacionesForm");
		
		view.addObject("estacion", estacion);
		
		return view;
	}
	
	public ModelAndView save(HttpServletRequest request,
		HttpServletResponse response, @ModelAttribute Estacion estacion) throws Exception {
				
		if (estacion != null)	
			service.save(estacion);

		response.sendRedirect("list");
		
		return null;
	}
	
	public void delete(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Linea linea) throws Exception {
			
		String id = request.getParameter("i") != null ? request.getParameter("i") : "";
		
		service.delete(Integer.parseInt(id));
			
		response.sendRedirect("list");
	}
	
	public ModelAndView search(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
				
		String searchParameter = request.getParameter("q") != null ? request.getParameter("q") : "";
		
		setEstaciones(
			service.findByParameter(searchParameter)
		);
		
		view.setViewName("estacionesList");
		view.addObject("estaciones", estaciones);
		view.addObject("paginationItems", null);
		
		return view;
	}
	
	public EstacionService getService() {
		return service;
	}

	public void setService(EstacionService service) {
		this.service = service;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public List<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public ModelAndView getView() {
		return view;
	}

	public void setView(ModelAndView view) {
		this.view = view;
	}
}
