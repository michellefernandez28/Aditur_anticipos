/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static util.Constantes.SEP;

/**
 *
 * @author Usuario
 */
public class Cliente_X_Evento {

    private int cedula, id_evento, cant_personas;
    private String grupo, detalles;

    public Cliente_X_Evento(int cedula, int id_evento, int cant_personas, String grupo, String detalles) {
        this.cedula = cedula;
        this.id_evento = id_evento;
        this.cant_personas = cant_personas;
        this.grupo = grupo;
        this.detalles = detalles;
    }

    public Cliente_X_Evento() {

    }

    // Convertir objeto a CSV (línea de texto)
    public String toCSV() {
        return cedula + SEP + id_evento + SEP + cant_personas + SEP + grupo + SEP + detalles.replace(SEP, ",");
    }

    // Convertir CSV (linea de texto) a objeto
    public static Cliente_X_Evento fromCSV(String linea) {
        //Separa por SEP ";" sin eliminar campos vacíos al final.
        String[] datos = linea.split(SEP, -1);
        if (datos.length != 5) {
            throw new IllegalArgumentException("Formato CSV inválido: " + linea);
        }
        return new Cliente_X_Evento(
                Integer.parseInt(datos[0]),
                Integer.parseInt(datos[1]),
                Integer.parseInt(datos[2]),
                datos[3],
                datos[4]
        );
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

}
