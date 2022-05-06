
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Residencia;
import com.curriculum.dinamico.service.IResidenciaService;
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
public class ResidenciaController {
    
    @Autowired
    private IResidenciaService residenciaS;
    
    @PostMapping("/residencia/crear")
    public String crearResidencia(@RequestBody Residencia residencia){
        residenciaS.saveResidencia(residencia);
        return "La nueva residencia fue guardada correctamente";
    }
    
    @GetMapping("/residencia/traer")
    public List<Residencia> traerResidencias(){
        List<Residencia> listaResidencias = residenciaS.getResidencia();
        
        return listaResidencias;
    }
    
    @PutMapping("/residencia/modificar/{id}")
    public Residencia modificarResidencia(@PathVariable Long id,
                                            @RequestParam ("direccion") String nuevaDireccion,
                                            @RequestParam ("localidad") String nuevaLocalidad,
                                            @RequestParam ("provincia") String nuevaProvincia,
                                            @RequestParam ("Pais") String nuevoPais,
                                            @RequestParam ("nacionalidad") String nuevaNacionalidad){
        
        Residencia unaResidencia = residenciaS.findOneResidencia(id);
        
        unaResidencia.setDireccion(nuevaDireccion);
        unaResidencia.setLocalidad(nuevaLocalidad);
        unaResidencia.setLocalidad(nuevaLocalidad);
        unaResidencia.setProvincia(nuevaProvincia);
        unaResidencia.setPais(nuevoPais);
        unaResidencia.setNacionalidad(nuevaNacionalidad);
        
        residenciaS.saveResidencia(unaResidencia);
        
        return unaResidencia;
        
    }
    
    @DeleteMapping("/residencia/eliminar/{id}")
    public String borrarUnaResidencia(@PathVariable Long id){
        residenciaS.deleteOneResidencia(id);
        return "La residencia fue borrada correctamente";
    }
}
