package org.lalosuarez.app.test.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.lalosuarez.app.mock.dao.MockLineaDaoImpl;
import org.lalosuarez.app.mock.dto.MockLinea;
import org.lalosuarez.app.service.LineaServiceImpl;

public class LineaServiceImplTest {

	private LineaServiceImpl lineaService;
	
	private MockLinea mockObject;
	
	@Before
	public void setUp() throws Exception {
		
		lineaService = new LineaServiceImpl();
		lineaService.setDao(new MockLineaDaoImpl());
		
		mockObject = new MockLinea();
		
	}

	@Test
	public void findTest() {		
		assertEquals(mockObject.getId(), lineaService.find(0).getId());
	}
	
	@Test
	public void findAllTest() {
		assertEquals(0, lineaService.findAll().size());
	}	

}
