
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public void crearProyecto(Proyecto proyecto);
    
    public List<Proyecto> getTodosLosProyectos();
    
    public Proyecto findOneProyecto(Long id);
    
    public void deleteOneProyecto(Long id);
    
}
