
package com.curriculum.dinamico.repository;

import com.curriculum.dinamico.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona,Long> {
    
    
}
