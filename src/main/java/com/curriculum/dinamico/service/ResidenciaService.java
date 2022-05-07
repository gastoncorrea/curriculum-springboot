
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Residencia;
import com.curriculum.dinamico.repository.ResidenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidenciaService implements IResidenciaService {
    
    @Autowired
    private ResidenciaRepository residenciaR;

    @Override
    public void saveResidencia(Residencia residencia) {
        residenciaR.save(residencia);
    }

    @Override
    public List<Residencia> getResidencia() {
        List<Residencia> listaResidencias = residenciaR.findAll();
        return listaResidencias;
    }

    @Override
    public Residencia findOneResidencia(Long id) {
        Residencia unaResidencia = residenciaR.findById(id).orElse(null);
        return unaResidencia;
    }

    @Override
    public void deleteOneResidencia(Long id) {
        residenciaR.deleteById(id);
    }
}
