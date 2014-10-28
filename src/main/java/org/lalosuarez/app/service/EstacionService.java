package org.lalosuarez.app.service;

import java.util.List;

import org.lalosuarez.app.dto.Estacion;

public interface EstacionService {

    public void save(Estacion object);
    
    public void delete(int id);
    
    public List<Estacion> findAll();
 
    public Estacion find(int id);
    
    public List<Estacion> findEstacionesByLinea(int id);
    
    public List<Estacion> findByParameter(String searchParameter);
}
