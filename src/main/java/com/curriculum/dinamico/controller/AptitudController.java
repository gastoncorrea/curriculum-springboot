
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Aptitud;
import com.curriculum.dinamico.service.IAptitudService;
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
public class AptitudController {
    
    @Autowired
    private IAptitudService aptitudS;
    
    @PostMapping("/aptitud/agregar")
    public String guardarAptitud(@RequestBody Aptitud aptitud){
        aptitudS.saveAptitud(aptitud);
        return "La aptitud fue guardada correctamente";
    }
    
    @GetMapping("/aptitud/traer")
    public List<Aptitud> traerAptitudes(){
        return aptitudS.getAptitud();
    }
    
    @PutMapping("/aptitud/modificar/{id}")
    public Aptitud modificarApitud(@PathVariable Long id,
                                    @RequestParam ("nombre") String nuevoNombre,
                                    @RequestParam ("url") int nuevoNivel){
        
        Aptitud findAptitud = aptitudS.findAptitud(id);
        
        findAptitud.setNombre(nuevoNombre);
        findAptitud.setNivel(nuevoNivel);
        
        aptitudS.saveAptitud(findAptitud);
        
        return findAptitud;     
    }
    
    @DeleteMapping("aptitud/borrar/{id}")
    public String borrarAptitud(@PathVariable Long id){
        aptitudS.deleteAptitud(id);
        return "La aptitud fue borrada correctamente";
    }
}
