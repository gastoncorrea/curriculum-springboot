
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Exp_laboral;
import com.curriculum.dinamico.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expService;
    
    @PostMapping("/experiencia/guardar")
    public String guardarExperiencia(@RequestBody Exp_laboral experiencia){
        expService.crearExperiecia(experiencia);
        return "La experiencia fue guardada correctamente";
    }
    
    @GetMapping("/experiencia/traer")
    public List<Exp_laboral> traerTodasLasExperiencias(){
        List<Exp_laboral> listaExperiencias = expService.traerExperiencias();
        return listaExperiencias;
    }
}
