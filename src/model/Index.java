/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;
//import dao.ClienteDAO;

import dao.EventoDAO;
import dao.ClienteXEventoDAO;
//import dao.PagoDAO;
import java.io.IOException;

/**
 *
 * @author miche
 */
public class Index {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            // Inicializar archivos CSV
            //ClienteDAO.inicializarArchivo();
            EventoDAO.inicializarArchivo();
            ClienteXEventoDAO.inicializarArchivo();
            //PagoDAO.inicializarArchivo();

        } catch (IOException e) {

            System.out.println("Error inicializando archivos:");
            e.printStackTrace();
            return;

        }

        // Iniciar interfaz
        inicioSesion iniciosesion = new inicioSesion();
        iniciosesion.setVisible(true);
    }

}
