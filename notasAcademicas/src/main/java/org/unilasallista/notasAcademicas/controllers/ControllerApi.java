package org.unilasallista.notasAcademicas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.unilasallista.notasAcademicas.entities.NotaEntityMongo;
import org.unilasallista.notasAcademicas.entities.NotaEntitySql;
import org.unilasallista.notasAcademicas.models.NotaModel;
import org.unilasallista.notasAcademicas.repositories.repositoryMongo;
import org.unilasallista.notasAcademicas.repositories.repositorySql;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("api/academico")
public class ControllerApi {
    @Autowired
    @Qualifier("repositoryMongo")
    private repositoryMongo repoMongo;
    @Autowired
    @Qualifier("repositorySql")
    private repositorySql repoSql;
    //create SQL & Mongo
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public NotaEntityMongo Create (@RequestBody NotaEntityMongo nota){
        NotaModel model = new NotaModel();
        model.setCodigoEstudiante(nota.getCodigoEstudiante());
        model.setNombre(nota.getNombre());
        model.setPorcentajeNota(nota.getPorcentajeNota());
        model.setCalificacion(nota.getCalificacion());
        model.setFechaRegistro(nota.getFechaRegistro());
        repoSql.save(model.toEntity()).toModel();
        repoMongo.save(nota);
        return(nota);
    }
    //update (SQL)
    @RequestMapping(value="/updateSql", method= RequestMethod.PUT)
    public NotaModel UpdateSql(@RequestBody NotaModel nota){
        return repoSql.save(nota.toEntity()).toModel();
    }
    //Delete (Mongo)
    @RequestMapping(value="/deleteMongo/{idNota}", method= RequestMethod.DELETE)
    public NotaEntityMongo DeleteMongo(@PathVariable ObjectId idNota) {
        NotaEntityMongo deleteNota = repoMongo.findById(idNota).get();
        repoMongo.deleteById(deleteNota.get_id());
        return deleteNota;
    }
    //Query nota max estudiante SQL
    @RequestMapping(value = "/querySql/{codigo}", method = RequestMethod.GET)
    public double QuerySql( @PathVariable double codigo){
        return repoSql.searchSql(codigo);
    }
    //Query nota debajo del promedio Mongo
    @RequestMapping(value = "/queryMongo/{codigoEstudiante}/{calificacion}", method = RequestMethod.GET)
    public List<NotaEntityMongo> QueryMongo(@PathVariable int codigoEstudiante, @PathVariable double calificacion){
        return repoMongo.searchMongo(codigoEstudiante,calificacion);
    }
}
