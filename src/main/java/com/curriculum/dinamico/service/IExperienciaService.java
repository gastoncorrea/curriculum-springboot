
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Exp_laboral;
import java.util.List;


public interface IExperienciaService {
    
    public void crearExperiecia(Exp_laboral experiencia);
    
    public List<Exp_laboral> traerExperiencias();
    
    public Exp_laboral encontrarUnaExperiencia(Long id);
    
    public void eliminarUnaExperiencia(Long id);
}
