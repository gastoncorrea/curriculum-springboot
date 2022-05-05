
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Exp_laboral;
import com.curriculum.dinamico.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class ExperienciaService implements IExperienciaService {
    @Autowired
    private ExperienciaRepository expRepository;
    
    @Override
    public void crearExperiecia(Exp_laboral experiencia) {
        expRepository.save(experiencia);
    }

    @Override
    public List<Exp_laboral> traerExperiencias() {
        List<Exp_laboral> listaExperiencia = expRepository.findAll();
        return listaExperiencia;
    }

    @Override
    public Exp_laboral encontrarUnaExperiencia(Long id) {
        Exp_laboral unaExperiencia = expRepository.findById(id).orElse(null);
        return unaExperiencia;
    }

    @Override
    public void eliminarUnaExperiencia(Long id) {
        expRepository.deleteById(id);
    }
    
}
