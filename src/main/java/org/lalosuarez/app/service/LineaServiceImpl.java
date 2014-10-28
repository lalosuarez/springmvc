package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dao.LineaDao;
import org.lalosuarez.app.dto.Linea;

public class LineaServiceImpl implements LineaService {

	private LineaDao dao;
	
	@Override
	public void save(Linea object) {
		dao.save(object);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public List<Linea> findAll() {
		return dao.findAll();
	}

	@Override
	public Linea find(int id) {
		return dao.find(id);
	}

	public LineaDao getDao() {
		return dao;
	}

	public void setDao(LineaDao dao) {
		this.dao = dao;
	}
}
