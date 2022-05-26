package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Persona;
import com.curriculum.dinamico.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/persona/crear")
    public String crearPersona(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
        return "La persona fue creada correctamente";
    }

    @GetMapping("/persona/traer")
    @ResponseBody
    public List<Persona> traerPersonas() {
        List<Persona> listaPersonas = personaService.traerTodasLasPersonas();
        return listaPersonas;
    }

    @DeleteMapping("/persona/borrar/{id}")
    public String borrarUnaPersona(@PathVariable Long id) {
        personaService.borrarUnaPersona(id);
        return "La persona fue borrada correctamente";
    }

    @PutMapping("/persona/modificar/{id}")
    @ResponseBody
    public Persona modificarPersona(@PathVariable Long id, @RequestParam("imagen_perfil") String nuevoPerfil,
            @RequestParam("descripcion_mi") String nuevaDescripcion, @RequestParam("url_linkedin") String nuevoLinkedin,
            @RequestParam("nombre") String nuevoNombre, @RequestParam("apellido") String nuevoApellido,
            @RequestParam ("num_celular") int nuevoNumero) {
                
        Persona findPersona = personaService.encontrarUnaPersona(id);
        findPersona.setImagen_perfil(nuevoPerfil);
        findPersona.setDescripcion_mi(nuevaDescripcion);
        findPersona.setUrl_linkedin(nuevoLinkedin);
        findPersona.setNombre(nuevoNombre);
        findPersona.setApellido(nuevoApellido);
        findPersona.setNum_celular(nuevoNumero);
        
        personaService.crearPersona(findPersona);
        return findPersona;
    }
}
