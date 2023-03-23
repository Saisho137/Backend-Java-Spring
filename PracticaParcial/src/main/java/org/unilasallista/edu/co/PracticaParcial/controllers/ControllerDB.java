package org.unilasallista.edu.co.PracticaParcial.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import org.unilasallista.edu.co.PracticaParcial.entities.VehiculoMongoDb;
import org.unilasallista.edu.co.PracticaParcial.entities.VehiculoSQLdb;
import org.unilasallista.edu.co.PracticaParcial.models.Vehiculo;
import org.unilasallista.edu.co.PracticaParcial.repositories.MongodbRepository;
import org.unilasallista.edu.co.PracticaParcial.repositories.SqlRepository;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("api/vehiculo")
public class ControllerDB {
    @Autowired
    @Qualifier("MongodbRepository")
    private MongodbRepository repoMongo;
    @Autowired
    @Qualifier("SqlRepository")
    private SqlRepository repoSql;

    //create
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public VehiculoMongoDb Create (@RequestBody VehiculoMongoDb carro){
        Vehiculo model = new Vehiculo();
        model.setMarca(carro.getMarca());
        model.setLinea(carro.getLinea());
        model.setModelo(carro.getModelo());
        model.setKilometraje(carro.getKilometraje());
        repoSql.save(model.toEntity()).toModel();
        repoMongo.save(carro);
        return(carro);
    }
    //Query
    @RequestMapping(value = "/queryMongo/{marca}/{modelo}", method = RequestMethod.GET)
    public List<VehiculoMongoDb> QueryMongo(@PathVariable String marca, @PathVariable int modelo){
        return repoMongo.searchMongo(marca,modelo);
    }
    @RequestMapping(value = "/querySql/{marca}/{modelo}", method = RequestMethod.GET)
    public List<VehiculoSQLdb> QuerySql(@PathVariable String marca, @PathVariable int modelo){
        return repoSql.searchSql(marca,modelo);
    }
    //Delete
    @RequestMapping(value="/deleteSql/{idVehiculo}", method= RequestMethod.DELETE)
    public Vehiculo DeleteSql(@PathVariable int idVehiculo){
        Vehiculo cursoAEliminar = repoSql.findById(idVehiculo).get().toModel();
        repoSql.deleteById(cursoAEliminar.getId());
        return cursoAEliminar;
    }
    @RequestMapping(value="/deleteMongo/{idVehiculo}", method= RequestMethod.DELETE)
    public VehiculoMongoDb DeleteMongo(@PathVariable ObjectId idVehiculo){
        VehiculoMongoDb cursoAEliminar = repoMongo.findById(idVehiculo).get();
        repoMongo.deleteById(cursoAEliminar.get_id());
        return cursoAEliminar;
    }
    //Update
    @RequestMapping(value="/updateSql", method= RequestMethod.PUT)
    public Vehiculo UpdateSql(@RequestBody Vehiculo carro){
        return repoSql.save(carro.toEntity()).toModel();
    }
    @RequestMapping(value="/updateMongo", method= RequestMethod.PUT)
    public VehiculoMongoDb UpdateMongo(@RequestBody VehiculoMongoDb carro){
        repoMongo.save(carro);
        return carro;
    }

}
