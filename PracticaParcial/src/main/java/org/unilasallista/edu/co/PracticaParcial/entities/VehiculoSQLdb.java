package org.unilasallista.edu.co.PracticaParcial.entities;

import org.bson.types.ObjectId;

import javax.persistence.*;
@Entity
@Table(name="VehiculoSQL")
public class VehiculoSQLdb  {
    @Id
    @GeneratedValue
    private int id;
    private String marca;
    private String linea;
    private int modelo;
    private int kilometraje;

    public VehiculoSQLdb(int id, String marca, String linea, int modelo, int kilometraje) {
        this.id = id;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }
    public VehiculoSQLdb() {
    }
    public org.unilasallista.edu.co.PracticaParcial.models.Vehiculo toModel(){
        return new org.unilasallista.edu.co.PracticaParcial.models.Vehiculo(
                this.id,this.marca,this.linea,this.modelo,this.kilometraje);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
