
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public void crearPersona(Persona persona);
    
    public List<Persona> traerTodasLasPersonas();
    
    public Persona encontrarUnaPersona(Long id);
    
    public void borrarUnaPersona(Long id);
}
