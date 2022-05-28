
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.dto.PersonaDto;
import com.curriculum.dinamico.model.Persona;
import com.curriculum.dinamico.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepository ;

    @Override
    public void crearPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public List<Persona> traerTodasLasPersonas() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public Persona encontrarUnaPersona(Long id) {
        Persona findPersona = personaRepository.findById(id).orElse(null);
        return findPersona;
    }

    @Override
    public void borrarUnaPersona(Long id) {
        personaRepository.deleteById(id);
    }

}
