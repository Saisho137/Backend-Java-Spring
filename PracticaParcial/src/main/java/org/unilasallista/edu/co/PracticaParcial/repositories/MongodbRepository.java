package org.unilasallista.edu.co.PracticaParcial.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unilasallista.edu.co.PracticaParcial.entities.VehiculoMongoDb;

import java.util.List;
@Repository("MongodbRepository")
public interface MongodbRepository extends MongoRepository <VehiculoMongoDb, ObjectId> {
    @Query("{'marca' : ?0, 'modelo':{'$gte': ?1}}")
    List<VehiculoMongoDb> searchMongo (String marca, int modelo);
}
