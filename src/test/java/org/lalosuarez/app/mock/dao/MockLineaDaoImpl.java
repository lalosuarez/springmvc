package org.lalosuarez.app.mock.dao;

import java.util.ArrayList;
import java.util.List;

import org.lalosuarez.app.dao.LineaDao;
import org.lalosuarez.app.dto.Linea;
import org.lalosuarez.app.mock.dto.MockLinea;

public class MockLineaDaoImpl implements LineaDao {

	@Override
	public void save(Linea object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Linea> findAll() {		
		return new ArrayList<Linea>();
	}

	@Override
	public Linea find(int id) {
		return new MockLinea();
	}
}
