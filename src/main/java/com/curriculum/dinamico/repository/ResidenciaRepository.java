
package com.curriculum.dinamico.repository;

import com.curriculum.dinamico.model.Residencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenciaRepository extends JpaRepository <Residencia, Long> {
    
}
