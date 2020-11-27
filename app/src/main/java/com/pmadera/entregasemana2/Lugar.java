package com.pmadera.entregasemana2;

public class Lugar {
    private String nombre;
    private int foto;
    private double latitud;
    private double longitud;

    public Lugar(String nombre, int foto, double latitud, double longitud) {
        this.nombre = nombre;
        this.foto = foto;
        this.latitud = latitud;
        this.longitud = longitud;
    }


    public Lugar(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
