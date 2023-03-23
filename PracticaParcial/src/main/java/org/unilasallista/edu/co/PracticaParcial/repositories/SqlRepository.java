package org.unilasallista.edu.co.PracticaParcial.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unilasallista.edu.co.PracticaParcial.entities.VehiculoSQLdb;

import java.util.List;
@Repository("SqlRepository")
public interface SqlRepository extends JpaRepository <VehiculoSQLdb, Integer> {
    @Query(value = "SELECT * FROM vehiculosql WHERE modelo >= :modelo and marca = :marca", nativeQuery = true)
    List<VehiculoSQLdb> searchSql (@Param("marca") String marca, @Param("modelo") int modelo);
}
