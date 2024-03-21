package com.mx.manytoone;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Persona {

    private String nombreCompleto;
    private Integer edad;
    private String genero;
    private LocalDate fechaNacimiento;
    private String correo;
    private String id;

    public void Persona() {
    }

    public Persona(String nombreCompleto, String genero, LocalDate fechaNacimiento, String correo, String id) {
        this.nombreCompleto = nombreCompleto;
        this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.id = id;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", correo='" + correo + '\'' +
                ", id=" + id +
                '}';
    }
}
