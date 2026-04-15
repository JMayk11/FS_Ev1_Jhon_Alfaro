package com.Alfaro.Jhon.model;

public class EventoDTO {
    private String nombre;
    private String ubicacion;
    public EventoDTO(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
}