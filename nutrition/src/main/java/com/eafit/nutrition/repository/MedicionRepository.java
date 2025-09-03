package com.eafit.nutrition.repository;

import com.eafit.nutrition.model.Medicion;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface MedicionRepository extends JpaRepository<Medicion, Long> {
    List<Medicion> findByPacienteIdOrderByFechaDesc(Long pacienteId);

    Optional<Medicion> findFirstByPacienteIdOrderByFechaDesc(Long pacienteId);

    // Consulta nativa para última medición
    @Query(value = "SELECT * FROM medicion WHERE paciente_id = :pacienteId ORDER BY fecha DESC LIMIT 1", nativeQuery = true)
    Optional<Medicion> findLastMedicionByPacienteId(Long pacienteId);
}