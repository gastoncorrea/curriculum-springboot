
package com.curriculum.dinamico.repository;

import com.curriculum.dinamico.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
    
    
}
