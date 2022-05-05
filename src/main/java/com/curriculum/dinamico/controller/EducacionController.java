
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Educacion;
import com.curriculum.dinamico.service.IEducacionService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PutMapping("/educacion/modificar/{id}")
    public Educacion modificarUnaEducacion(@PathVariable Long id,
                                            @RequestParam ("nombre_institucion") String nuevoNombre,
                                            @RequestParam ("fecha_inicio") Calendar nuevaFechaInicio,
                                            @RequestParam ("fecha_fin") Calendar nuevaFechaFin,
                                            @RequestParam ("titulo") String nuevoTitulo){
        
        Educacion modificarEducacion = educacionS.obtenerUnaEducacion(id);
        
        modificarEducacion.setNombre_institucion(nuevoNombre);
        modificarEducacion.setFecha_inicio(nuevaFechaInicio);
        modificarEducacion.setFecha_fin(nuevaFechaFin);
        modificarEducacion.setTitulo(nuevoTitulo);
        
        educacionS.crearNuevaeducacion(modificarEducacion);
        return modificarEducacion;
        
        
    }
    
    @DeleteMapping ("/educacion/eliminar/{id}")
    public String borrarUnaEducacion(@PathVariable Long id ){
        educacionS.eliminarUnaEducacion(id);
        return "el registro fue eliminado";
    }
}
