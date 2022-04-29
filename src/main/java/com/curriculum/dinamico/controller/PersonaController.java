
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Persona;
import com.curriculum.dinamico.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @PostMapping("/persona/crear")
    public String crearPersona(@RequestBody Persona persona){
        personaService.crearPersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @GetMapping ("/persona/traer")
    public List<Persona> traerPersonas(){
        List<Persona> listaPersonas = personaService.traerTodasLasPersonas();
        return listaPersonas;
    }
}
