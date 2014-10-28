package org.lalosuarez.app.mock.dto;

import org.lalosuarez.app.dto.Linea;

public class MockLinea extends Linea {
	
	public MockLinea() {
		setId(100);
		setNombre("MokcLinea");
		setColor("MockColor");
		setEstaciones(null);
	}
	
}
