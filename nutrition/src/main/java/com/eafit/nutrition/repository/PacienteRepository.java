package com.eafit.nutrition.repository;

import com.eafit.nutrition.model.Paciente;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // Proyección (devuelve solo algunos campos)
    interface PacienteResumen {
        Long getId();
        String getNombre();
        String getApellido();
    }

    @Query("SELECT p.id as id, p.nombre as nombre, p.apellido as apellido " +
           "FROM Paciente p WHERE p.nutricionista.id = :nutricionistaId")
    List<PacienteResumen> findPacienteResumenByNutricionistaId(@Param("nutricionistaId") Long nutricionistaId);
}