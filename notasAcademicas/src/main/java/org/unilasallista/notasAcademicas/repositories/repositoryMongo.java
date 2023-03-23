package org.unilasallista.notasAcademicas.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unilasallista.notasAcademicas.entities.NotaEntityMongo;
import java.util.List;
@Repository("repositoryMongo")
public interface repositoryMongo extends MongoRepository <NotaEntityMongo, ObjectId> {
    @Query("{'codigoEstudiante' : ?0, 'calificacion':{'$lt': ?1}}")
    List<NotaEntityMongo> searchMongo (int codigoEstudiante, double calificacion);
}
