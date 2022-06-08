package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Exp_laboral;
import com.curriculum.dinamico.service.IExperienciaService;
import java.util.Date;
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
@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaController {

    @Autowired
    private IExperienciaService expService;

    @PostMapping("/experiencia/guardar")
    public String guardarExperiencia(@RequestBody Exp_laboral experiencia) {
        expService.crearExperiecia(experiencia);
        return "La experiencia fue guardada correctamente";
    }

    @GetMapping("/experiencia/traer")
    public List<Exp_laboral> traerTodasLasExperiencias() {
        List<Exp_laboral> listaExperiencias = expService.traerExperiencias();
        return listaExperiencias;
    }

        @PutMapping("/experiencia/modificar/{id}")
    public Exp_laboral modificarUnaExperiencia(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("puesto") String nuevoPuesto,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("logo") String nuevoLogo,
            @RequestParam("fecha_inicio") Date nuevaFechaInicio,
            @RequestParam("fecha_fin") Date nuevaFechaFin,
            @RequestParam("tiempo_trab") String nuevoTiempo) {

        Exp_laboral encontrarUnaExperiencia = expService.encontrarUnaExperiencia(id);

        encontrarUnaExperiencia.setNombre(nuevoNombre);
        encontrarUnaExperiencia.setPuesto(nuevoPuesto);
        encontrarUnaExperiencia.setDescripcion(nuevaDescripcion);
        encontrarUnaExperiencia.setLogo(nuevoLogo);
        encontrarUnaExperiencia.setFecha_inicio(nuevaFechaInicio);
        encontrarUnaExperiencia.setFecha_fin(nuevaFechaFin);
        encontrarUnaExperiencia.setTiempo_trab(nuevoTiempo);
        
        expService.crearExperiecia(encontrarUnaExperiencia);
        return encontrarUnaExperiencia;
    }
    
    @DeleteMapping ("/experiencia/borrar/{id}")
    public String borrarExperiencia(@PathVariable Long id){
        expService.eliminarUnaExperiencia(id);
        return "La Experiencia laboral fue eliminada";
    }
    
    
}
