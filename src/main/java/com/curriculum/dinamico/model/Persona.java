
package com.curriculum.dinamico.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    //aca tengo una duda el tipo de dato es usuario o el tipo de dato que ya tiene el id en usuario?
    @OneToOne
    private Usuario id_usuario;
    
    @OneToMany(mappedBy = "persona")
    private List<Educacion> educacion;
}
