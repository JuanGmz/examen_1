package com.juantrc.examen_1.modelos;

import android.content.Intent;

import java.io.Serializable;
import java.time.format.DecimalStyle;

public class Persona implements Serializable {
    public String nombre;
    public transient Intent accion;
    public String numero;
    public String descripcion;
    public transient Intent mapa;
    public transient Intent num;

    public Persona(String nombre, Intent accion, String numero, String descripcion) {
        this.nombre = nombre;
        this.accion = accion;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNumero() {
        return numero;
    }

    public Intent getMapa() {
        return mapa;
    }

    public Intent getNum() {
        return num;
    }
}