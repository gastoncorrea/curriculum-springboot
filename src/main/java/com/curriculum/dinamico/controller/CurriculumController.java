
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.dto.PersonaDto;
import com.curriculum.dinamico.model.Aptitud;
import com.curriculum.dinamico.model.Educacion;
import com.curriculum.dinamico.model.Exp_laboral;
import com.curriculum.dinamico.model.Persona;
import com.curriculum.dinamico.model.Proyecto;
import com.curriculum.dinamico.model.Residencia;
import com.curriculum.dinamico.model.Usuario;
import com.curriculum.dinamico.service.IAptitudService;
import com.curriculum.dinamico.service.IEducacionService;
import com.curriculum.dinamico.service.IExperienciaService;
import com.curriculum.dinamico.service.IPersonaService;
import com.curriculum.dinamico.service.IProyectoService;
import com.curriculum.dinamico.service.IResidenciaService;
import com.curriculum.dinamico.service.UsuarioService;
import com.curriculum.dinamico.util.JwtUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurriculumController {
    
    @Autowired
    private UsuarioService usuarioS;
    @Autowired
    private IPersonaService personaS;
    @Autowired
    private IResidenciaService residenciaS;
    @Autowired
    private IEducacionService educacionS;
    @Autowired
    private IExperienciaService experienciaS;
    @Autowired
    private IAptitudService aptitudS;
    @Autowired
    private IProyectoService proyectoS;
    
    @GetMapping("/curriculum/persona/{email}")
    @ResponseBody
    public PersonaDto encontrarPersona(@PathVariable String email){
        List<Persona> listaPersona = personaS.traerTodasLasPersonas();
        List<Residencia> listaResidencia = residenciaS.getResidencia();
        List<Educacion> listaEducacion = educacionS.obtenerEducacion();
        List<Exp_laboral> listaExperiencia = experienciaS.traerExperiencias();
        List<Aptitud> listaAptitud = aptitudS.getAptitud();
        List<Proyecto> listaProyecto = proyectoS.getTodosLosProyectos();
        //Variable que guarda el valor de la "persona" encontrada por email
        Long personaEncontrada = null;
        Residencia construirResidencia = null;
        List<Educacion> construirListaEducacion = new ArrayList();
        List<Exp_laboral> construirListaExpLaboral = new ArrayList();
        List<Aptitud> construirListaAptitud = new ArrayList();
        List<Proyecto> construirListaProyecto = new ArrayList();
        //Variable que contiene el "id" de la persona buscada por email
       Long idEncontrada = usuarioS.obtenerIdConEmail(email);
        Usuario usuario = usuarioS.encontrarUnUsuario(idEncontrada);
        for(Persona pers : listaPersona){
            if(pers.getIdusuario().getIdusuario().equals(idEncontrada)){
                personaEncontrada = pers.getIdpersona();
            }
        }
        
        for(Residencia res : listaResidencia){
            if(res.getPersona().getIdpersona().equals(personaEncontrada)){
                construirResidencia = residenciaS.findOneResidencia(res.getIdresidencia());
            }
        }
        
        for(Educacion edu : listaEducacion){
            if(edu.getPersona().getIdpersona().equals(personaEncontrada))
                construirListaEducacion.add(edu);
        }
        
        for(Exp_laboral exp : listaExperiencia){
            if(exp.getPersona().getIdpersona().equals(personaEncontrada)){
                construirListaExpLaboral.add(exp);
            }
        }
        
        for(Aptitud apt: listaAptitud){
            if(apt.getPersona().getIdpersona().equals(personaEncontrada)){
                construirListaAptitud.add(apt);
            }
        }
        
        for(Proyecto proy : listaProyecto){
            if(proy.getPersona().getIdpersona().equals(personaEncontrada)){
                construirListaProyecto.add(proy);
            }
        }
        
        PersonaDto persDto = new PersonaDto();
        Persona construirPersona = personaS.encontrarUnaPersona(personaEncontrada);
        persDto.setUsuario(usuario);
        persDto.setIdPersona(construirPersona.getIdpersona());
        persDto.setNombrePersona(construirPersona.getNombre());
        persDto.setApellidoPersona(construirPersona.getApellido());
        persDto.setNum_celular(construirPersona.getNum_celular());
        persDto.setImagen_perfil(construirPersona.getImagen_perfil());
        persDto.setDescripcion_mi(construirPersona.getDescripcion_mi());
        persDto.setUrl_linkedin(construirPersona.getUrl_linkedin());
        persDto.setResidencia(construirResidencia);
        persDto.setEducacion(construirListaEducacion);
        persDto.setExperiencia(construirListaExpLaboral);
        persDto.setAptitud(construirListaAptitud);
        persDto.setProyecto(construirListaProyecto);
        
        return persDto;
       
    }
}
