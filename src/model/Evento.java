/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author miche
 */
public class Evento {
    
    private int idEvento, cantDias, cantidadParticipantes;
    private String nombre, detalles;
    private EstadoEvento estado;
    private java.time.LocalDate fecha;
    private double montoPersona;
    
    public enum EstadoEvento {
        Programado, Activo, Finalizado, Cancelado
    }

    public Evento() {
    }

    public Evento(int idEvento, int cantDias, int cantidadParticipantes, String nombre, String detalles, EstadoEvento estado, LocalDate fecha, double montoPersona) {
        this.idEvento = idEvento;
        this.cantDias = cantDias;
        this.cantidadParticipantes = cantidadParticipantes;
        this.nombre = nombre;
        this.detalles = detalles;
        this.estado = estado;
        this.fecha = fecha;
        this.montoPersona = montoPersona;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMontoPersona() {
        return montoPersona;
    }

    public void setMontoPersona(double montoPersona) {
        this.montoPersona = montoPersona;
    }
    
    
}
