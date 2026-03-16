/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import static util.Constantes.SEP;

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

    // Convertir objeto a CSV (línea de texto)
    public String toCSV() {
        return idEvento + SEP + cantDias + SEP + cantidadParticipantes + SEP
                + nombre + SEP + detalles.replace(SEP, ",") + SEP
                + estado + SEP + fecha + SEP + montoPersona;
    }

    // Convertir CSV (linea de texto) a objeto
    public static Evento fromCSV(String linea) {
        //Separa por SEP ";" sin eliminar campos vacíos al final.
        String[] datos = linea.split(SEP, -1);
        if (datos.length != 8) {
            throw new IllegalArgumentException("Formato CSV inválido: " + linea);
        }
        return new Evento(
                Integer.parseInt(datos[0]),
                Integer.parseInt(datos[1]),
                Integer.parseInt(datos[2]),
                datos[3],
                datos[4],
                EstadoEvento.valueOf(datos[5]),
                java.time.LocalDate.parse(datos[6]),
                Double.parseDouble(datos[7])
        );
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
