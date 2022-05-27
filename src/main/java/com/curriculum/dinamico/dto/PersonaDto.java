
package com.curriculum.dinamico.dto;

import com.curriculum.dinamico.model.Aptitud;
import com.curriculum.dinamico.model.Educacion;
import com.curriculum.dinamico.model.Exp_laboral;
import com.curriculum.dinamico.model.Proyecto;
import com.curriculum.dinamico.model.Residencia;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDto implements Serializable  {
    
    private Long idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private int num_celular;
    private String imagen_perfil;
    private String descripcion_mi;
    private String url_linkedin;
    private Residencia residencia;
    private List<Educacion> educacion;
    private List<Exp_laboral> experiencia;
    private List<Aptitud> aptitud;
    private List<Proyecto> proyecto;
    
}
