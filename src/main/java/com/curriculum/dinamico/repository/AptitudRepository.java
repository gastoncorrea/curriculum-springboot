
package com.curriculum.dinamico.repository;

import com.curriculum.dinamico.model.Aptitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptitudRepository extends JpaRepository<Aptitud,Long> {
    
}
