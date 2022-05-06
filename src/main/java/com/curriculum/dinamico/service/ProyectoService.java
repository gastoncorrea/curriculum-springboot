
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Proyecto;
import com.curriculum.dinamico.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository proyectoR;

    @Override
    public void crearProyecto(Proyecto proyecto) {
        proyectoR.save(proyecto);
    }

    @Override
    public List<Proyecto> getTodosLosProyectos() {
        List<Proyecto> todosLosProyectos = proyectoR.findAll();
        return todosLosProyectos;
    }

    @Override
    public Proyecto findOneProyecto(Long id) {
        Proyecto unProyecto = proyectoR.findById(id).orElse(null);
        return unProyecto;
    }

    @Override
    public void deleteOneProyecto(Long id) {
        proyectoR.deleteById(id);
    }
    
    
}
