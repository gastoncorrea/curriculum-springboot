
package com.curriculum.dinamico.repository;

import com.curriculum.dinamico.model.Exp_laboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Exp_laboral, Long>{
    
}
