package org.unilasallista.notasAcademicas.models;

public class NotaModel {
    private int id;
    private int codigoEstudiante;
    private String nombre;
    private double porcentajeNota;
    private double calificacion;
    private String fechaRegistro;

    public NotaModel(int id, int codigoEstudiante, String nombre, double porcentajeNota, double calificacion, String fechaRegistro) {
        this.id = id;
        this.codigoEstudiante = codigoEstudiante;
        this.nombre = nombre;
        this.porcentajeNota = porcentajeNota;
        this.calificacion = calificacion;
        this.fechaRegistro = fechaRegistro;
    }

    public NotaModel() {
    }

    public org.unilasallista.notasAcademicas.entities.NotaEntitySql toEntity(){
        return new org.unilasallista.notasAcademicas.entities.NotaEntitySql(this.id,this.codigoEstudiante,this.nombre,
                this.porcentajeNota,this.calificacion,this.fechaRegistro);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
