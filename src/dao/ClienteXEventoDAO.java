/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente_X_Evento;
import util.CSVUtility;
import util.Constantes;
import static util.Constantes.SEP;

/**
 *
 * @author Usuario
 */
public class ClienteXEventoDAO {

    public static void inicializarArchivo() throws IOException {

        CSVUtility.crearArchivo(
                Constantes.ARCHIVO_CLIENTE_EVENTO,
                "cedula" + SEP + "id_Evento" + SEP + "grupo" + SEP + "cant_personas" + SEP + "detalles"
        );

    }

    public static void guardar(Cliente_X_Evento obj) throws IOException {

        if (ClienteXEventoDAO.existeInscripcion(obj.getCedula(), obj.getId_evento())) {
            System.out.println("El cliente ya está inscrito en este evento.");
            return;
        }

        CSVUtility.escribirLinea(
                Constantes.ARCHIVO_CLIENTE_EVENTO,
                obj.toCSV()
        );

    }

    public static boolean existeInscripcion(int cedula, int idEvento) throws IOException {

        List<Cliente_X_Evento> lista = listar();

        for (Cliente_X_Evento c : lista) {
            if (c.getCedula() == cedula && c.getId_evento() == idEvento) {
                return true;
            }
        }

        return false;
    }

    public static List<Cliente_X_Evento> listar() throws IOException {

        List<Cliente_X_Evento> lista = new ArrayList<>();

        List<String> lineas = CSVUtility.leerLineas(
                Constantes.ARCHIVO_CLIENTE_EVENTO
        );

        for (int i = 1; i < lineas.size(); i++) {
            lista.add(Cliente_X_Evento.fromCSV(lineas.get(i)));
        }

        return lista;
    }

    public static void eliminar(int cedula, int idEvento) throws IOException {
        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_CLIENTE_EVENTO);

        List<String> nuevasLineas = new ArrayList<>();

        nuevasLineas.add(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {
            Cliente_X_Evento c = Cliente_X_Evento.fromCSV(lineas.get(i));
            if (!(c.getCedula() == cedula && c.getId_evento() == idEvento)) {
                nuevasLineas.add(lineas.get(i));
            }

        }

        CSVUtility.sobrescribirArchivo(Constantes.ARCHIVO_CLIENTE_EVENTO, nuevasLineas);
    }

    public static void actualizar(Cliente_X_Evento actualizado) throws IOException {

        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_CLIENTE_EVENTO);
        List<String> nuevasLineas = new ArrayList<>();

        nuevasLineas.add(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {
            Cliente_X_Evento c = Cliente_X_Evento.fromCSV(lineas.get(i));
            if (c.getCedula() == actualizado.getCedula() && c.getId_evento() == actualizado.getId_evento()) {
                nuevasLineas.add(actualizado.toCSV());
            } else {
                nuevasLineas.add(lineas.get(i));
            }

        }

        CSVUtility.sobrescribirArchivo(Constantes.ARCHIVO_CLIENTE_EVENTO, nuevasLineas);
    }

    public static List<Cliente_X_Evento> buscarPorCedula(int cedula) throws IOException {
        List<Cliente_X_Evento> resultado = new ArrayList<>();
        List<Cliente_X_Evento> lista = listar();
        for (Cliente_X_Evento c : lista) {
            if (c.getCedula() == cedula) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public static List<Cliente_X_Evento> buscarPorEvento(int idEvento) throws IOException {
        List<Cliente_X_Evento> resultado = new ArrayList<>();
        List<Cliente_X_Evento> lista = listar();
        for (Cliente_X_Evento c : lista) {
            if (c.getId_evento() == idEvento) {
                resultado.add(c);
            }
        }
        return resultado;
    }

}
