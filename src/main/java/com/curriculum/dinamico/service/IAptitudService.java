
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Aptitud;
import java.util.List;


public interface IAptitudService {
    
    public void saveAptitud(Aptitud aptitud);
    
    public List<Aptitud> getAptitud();
    
    public Aptitud findAptitud(Long id);
    
    public void deleteAptitud(Long id);
}
