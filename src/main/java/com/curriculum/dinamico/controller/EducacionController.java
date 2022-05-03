
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Educacion;
import com.curriculum.dinamico.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionS;
    
    @PostMapping("/educacion/guardar")
    public String agregarEducacion(@RequestBody Educacion educacion){
        educacionS.crearNuevaeducacion(educacion);
        return "Se agrego nueva educacion";
    }
    
    @GetMapping("/educacion/consultar")
    public List<Educacion> traerListaEducacion(){
        return educacionS.obtenerEducacion();
    }
}
