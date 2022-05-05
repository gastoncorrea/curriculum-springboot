
package com.curriculum.dinamico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Calendar;
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
@Table(name = "experiencias_laborales")
public class Exp_laboral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idexp_laboral;
    private String nombre;
    private String puesto;
    private String logo;
    private Calendar fecha_inicio;
    private Calendar fecha_fin;
    private String tiempo_trab;
    
    @ManyToOne
    //@JsonIgnore
    private Persona persona;
    
}
