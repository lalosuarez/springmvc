package org.lalosuarez.app.test.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.lalosuarez.app.mock.dao.MockLineaDaoImpl;
import org.lalosuarez.app.mock.dto.MockLinea;

public class LineaDaoImplTest {

	private MockLineaDaoImpl mockLineaDaoImpl;
	
	private MockLinea mockObject;
	
	@Before
	public void setUp() throws Exception {
		mockLineaDaoImpl = new MockLineaDaoImpl();
		mockObject = new MockLinea();
	}

	@Test
	public void findTest() {		
		assertEquals(mockObject.getId(), mockLineaDaoImpl.find(0).getId());
	}
	
	@Test
	public void findAllTest() {
		assertEquals(0, mockLineaDaoImpl.findAll().size());
	}	

}
