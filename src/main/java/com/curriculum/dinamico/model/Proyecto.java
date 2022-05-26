
package com.curriculum.dinamico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "proyectos")
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idproyecto;
    private String nombre;
    private String descripcion;
    private String url;
    
    @ManyToOne
    //@JsonIgnore
    private Persona persona;
}
