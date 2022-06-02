
package com.curriculum.dinamico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idpersona;
    private String imagen_perfil;
    private String descripcion_mi;
    private String url_linkedin;
    private String nombre;
    private String apellido;
    private String num_celular;
    
    //relaciones entre tablas
    @OneToOne
    private Usuario idusuario;
    
    /*@OneToOne(mappedBy = "persona")
    private Residencia idresidencia;
    */
    
    @OneToMany(mappedBy = "persona")
    @JsonIgnore
    private List<Educacion> educacion;
    
    @OneToMany (mappedBy = "persona")
    @JsonIgnore
    private List<Proyecto> proyecto;
    
    @OneToMany (mappedBy = "persona")   
    @JsonIgnore
    private List<Exp_laboral> experiencia_laboral;
    
    @OneToMany (mappedBy = "persona")
    @JsonIgnore
    private List<Aptitud> aptitud;   
    
}
