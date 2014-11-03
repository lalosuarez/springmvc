package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dto.Linea;

public interface LineaService {
	
    public void save(Linea object);
    
    public void delete(int id);
    
    public List<Linea> findAll();
 
    public Linea find(int id);	
}
