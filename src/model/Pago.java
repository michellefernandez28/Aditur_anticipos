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
public class Pago {
    private int id_pago;
    private java.time.LocalDate fecha;
    private double monto;
    
    private Cliente cliente;
    private Evento evento;

    public Pago() {
    }

    public Pago(int id_pago, LocalDate fecha, double monto, Cliente cliente, Evento evento) {
        this.id_pago = id_pago;
        this.fecha = fecha;
        this.setMonto(monto);
        this.cliente = cliente;
        this.evento = evento;
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
        }else{
            System.out.println("Lo sentimos, el monto debe ser mayor a 0");
        }
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    
    
    }

    

