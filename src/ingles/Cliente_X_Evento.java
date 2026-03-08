/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ingles;

/**
 *
 * @author Usuario
 */
public class Cliente_X_Evento {

    private int cedula, id_evento, cant_personas;
    private String grupo, detalle;

    public Cliente_X_Evento(int cedula, int id_evento, int cant_personas, String grupo, String detalle) {
        this.cedula = cedula;
        this.id_evento = id_evento;
        this.cant_personas = cant_personas;
        this.grupo = grupo;
        this.detalle = detalle;
    }

    public Cliente_X_Evento() {

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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
