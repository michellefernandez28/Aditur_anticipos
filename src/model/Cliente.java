/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static util.Constantes.SEP;

/**
 *
 * @author miche
 */
public class Cliente {

    private int cedula;
    private String nombre, apellido;

    public Cliente() {
    }

    public Cliente(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Convertir objeto a CSV (línea de texto)
    public String toCSV() {
        return cedula + SEP + nombre + SEP + apellido;
    }

    // Convertir CSV (linea de texto) a objeto
    public static Cliente fromCSV(String linea) {
        //Separa por SEP ";" sin eliminar campos vacíos al final.
        String[] datos = linea.split(SEP, -1);
        if (datos.length != 3) {
            throw new IllegalArgumentException("Formato CSV inválido: " + linea);
        }
        return new Cliente(
                Integer.parseInt(datos[0]),
                datos[1],
                datos[2]
        );
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
