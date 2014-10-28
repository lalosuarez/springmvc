package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dao.EstacionDao;
import org.lalosuarez.app.dto.Estacion;

public class EstacionServiceImpl implements EstacionService {

	private EstacionDao dao;
	
	@Override
	public void save(Estacion object) {
		dao.save(object);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public List<Estacion> findAll() {
		return dao.findAll();
	}

	@Override
	public Estacion find(int id) {
		return dao.find(id);
	}

	@Override
	public List<Estacion> findEstacionesByLinea(int id) {
		return dao.findEstacionesByLinea(id);
	}

	@Override
	public List<Estacion> findByParameter(String searchParameter) {
		return dao.findByParameter(searchParameter);
	}
	
	public EstacionDao getDao() {
		return dao;
	}

	public void setDao(EstacionDao dao) {
		this.dao = dao;
	}
}
