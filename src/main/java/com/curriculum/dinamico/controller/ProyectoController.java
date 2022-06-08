
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Proyecto;
import com.curriculum.dinamico.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoS;
    
    @PostMapping("/proyecto/crear")
    public String guardarProyecto(@RequestBody Proyecto proyecto){
        proyectoS.crearProyecto(proyecto);
        return "Proyecto guardado correctamente";
    }
    
    @GetMapping("/proyecto/traer")
    public List<Proyecto> getTodosLosProyectos(){
        List<Proyecto> todosLosProyectos = proyectoS.getTodosLosProyectos();
        return todosLosProyectos;
    }
    
    @PutMapping("/proyecto/modificar/{id}")
    public Proyecto modiciarUnProyecto(@PathVariable Long id,
                                       @RequestParam ("nombre") String nuevoNombre,
                                        @RequestParam ("descripcion") String nuevaDescripcion,
                                        @RequestParam ("url") String nuevaUrl){
        
        Proyecto unProyecto = proyectoS.findOneProyecto(id);
        
        unProyecto.setNombre(nuevoNombre);
        unProyecto.setDescripcion(nuevaDescripcion);
        unProyecto.setUrl(nuevaUrl);
        
        proyectoS.crearProyecto(unProyecto);
        
        return unProyecto;
    }
    
    @DeleteMapping("/proyecto/eliminar/{id}")
    public String borrarUnProyecto(@PathVariable Long id){
        proyectoS.deleteOneProyecto(id);
        return "El proyecto fue eliminado de manera exitosa";
    }
    
}
