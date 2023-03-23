package org.unilasallista.notasAcademicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unilasallista.notasAcademicas.entities.NotaEntitySql;
import java.util.List;
@Repository("repositorySql")
public interface repositorySql extends JpaRepository <NotaEntitySql, Integer> {
    @Query(value = "SELECT MAX(calificacion) FROM calificaciones WHERE codigo_estudiante = :codigo", nativeQuery = true)
    double searchSql (@Param("codigo") double codigo);
}