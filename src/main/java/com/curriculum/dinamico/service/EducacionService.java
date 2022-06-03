
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Educacion;
import com.curriculum.dinamico.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository educacionR;

    @Override
    public void crearNuevaeducacion(Educacion educacion) {
        educacionR.save(educacion);
    }

    @Override
    public List<Educacion> obtenerEducacion() {
        List<Educacion> listaEducacion = educacionR.findAll();
        return listaEducacion;
    }

    @Override
    public Educacion obtenerUnaEducacion(Long id) {
        Educacion unaEducacion = educacionR.findById(id).orElse(null);
        return unaEducacion;
    }

    @Override
    public void eliminarUnaEducacion(Long id) {
        educacionR.deleteById(id);
    }
}
