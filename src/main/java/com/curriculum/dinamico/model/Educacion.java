
package com.curriculum.dinamico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table (name = "educacion")
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ideducacion;
    private String nombre_institucion;
    private String logo;
    @Temporal(TemporalType.DATE)
    private Date fecha_inicio;
    @Temporal(TemporalType.DATE)
    private Date fecha_fin;
    private String titulo;
    
    @ManyToOne
    //@JsonIgnore
    private Persona persona;
       
}
