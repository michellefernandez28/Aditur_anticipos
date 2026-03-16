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
public class Pago {

    private int id_pago;
    private java.time.LocalDate fecha;
    private double monto;

    private int cedula;
    private int id_evento;

    public Pago() {
    }

    public Pago(int id_pago, LocalDate fecha, double monto, int cedula, int id_evento) {
        this.id_pago = id_pago;
        this.fecha = fecha;
        this.setMonto(monto);
        this.cedula = cedula;
        this.id_evento = id_evento;
    }

    // Convertir objeto a CSV (línea de texto)
    public String toCSV() {
        return id_pago + SEP + fecha + SEP + monto + SEP + cedula + SEP + id_evento;
    }

    // Convertir CSV (linea de texto) a objeto
    public static Pago fromCSV(String linea) {
        //Separa por SEP ";" sin eliminar campos vacíos al final.
        String[] datos = linea.split(SEP, -1);
        if (datos.length != 5) {
            throw new IllegalArgumentException("Formato CSV inválido: " + linea);
        }
        return new Pago(
                Integer.parseInt(datos[0]),
                java.time.LocalDate.parse(datos[1]),
                Double.parseDouble(datos[2]),
                Integer.parseInt(datos[3]),
                Integer.parseInt(datos[4])
        );
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto > 0) {
            this.monto = monto;
        } else {
            System.out.println("Lo sentimos, el monto debe ser mayor a 0");
        }

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

}
