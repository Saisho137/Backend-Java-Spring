package org.unilasallista.edu.co.PracticaParcial.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
@Document(collection = "AgenciaVehiculos")
public class VehiculoMongoDb {
    @Id
    private ObjectId _id;
    private String marca;
    private String linea;
    private int modelo;
    private int kilometraje;

    public VehiculoMongoDb(ObjectId _id, String marca, String linea, int modelo, int kilometraje) {
        this._id = _id;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }
    public VehiculoMongoDb() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
}
