
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Residencia;
import java.util.List;


public interface IResidenciaService {
    
    public void saveResidencia(Residencia residencia);
    
    public List<Residencia> getResidencia();
    
    public Residencia findOneResidencia(Long id);
    
    public void deleteOneResidencia(Long id);
    
}
