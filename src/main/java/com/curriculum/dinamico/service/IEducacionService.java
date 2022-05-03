
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public void crearNuevaeducacion(Educacion educacion);
    
    public List<Educacion> obtenerEducacion();
    
    public Educacion obtenerUnaEducacion(Long id);
    
    public void eliminarUnaEducacion(Long id);
}
