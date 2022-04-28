
package com.curriculum.dinamico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "residencia")
public class Residencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idresidencia;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private String nacionalidad;
    
    @OneToOne
    private Persona persona;
    
}
