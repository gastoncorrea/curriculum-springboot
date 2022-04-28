
package com.curriculum.dinamico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long idusuario;
    private String email;
    private String password;
}
