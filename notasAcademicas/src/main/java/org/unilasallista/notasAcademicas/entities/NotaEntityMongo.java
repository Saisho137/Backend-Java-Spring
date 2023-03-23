package org.unilasallista.notasAcademicas.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
@Document(collection = "Notas")
public class NotaEntityMongo {
    @Id
    private ObjectId _id;
    private int codigoEstudiante;
    private String nombre;
    private double porcentajeNota;
    private double calificacion;
    private String fechaRegistro;

    public NotaEntityMongo(ObjectId _id, int codigoEstudiante, String nombre, double porcentajeNota, int calificacion, String fechaRegistro) {
        this._id = _id;
        this.codigoEstudiante = codigoEstudiante;
        this.nombre = nombre;
        this.porcentajeNota = porcentajeNota;
        this.calificacion = calificacion;
        this.fechaRegistro = fechaRegistro;
    }

    public NotaEntityMongo() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentajeNota() {
        return porcentajeNota;
    }

    public void setPorcentajeNota(double porcentajeNota) {
        this.porcentajeNota = porcentajeNota;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
