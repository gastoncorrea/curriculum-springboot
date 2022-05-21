
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Aptitud;
import com.curriculum.dinamico.repository.AptitudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AptitudService implements IAptitudService {
    @Autowired
    private AptitudRepository aptitudR;
    
    @Override
    public void saveAptitud(Aptitud aptitud) {
        aptitudR.save(aptitud);
    }

    @Override
    public List<Aptitud> getAptitud() {
        List<Aptitud> listaAptitudes = aptitudR.findAll();
        return listaAptitudes;
    }

    @Override
    public Aptitud findAptitud(Long id) {
        Aptitud findAptitud = aptitudR.findById(id).orElse(null);
        return findAptitud;
    }

    @Override
    public void deleteAptitud(Long id) {
        aptitudR.deleteById(id);
    }
    
    
}
