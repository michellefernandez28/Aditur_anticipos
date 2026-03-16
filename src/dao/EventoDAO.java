/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Evento;
import util.CSVUtility;
import util.Constantes;
import static util.Constantes.SEP;

/**
 *
 * @author Usuario
 */
public class EventoDAO {

    public static void inicializarArchivo() throws IOException {

        CSVUtility.crearArchivo(
                Constantes.ARCHIVO_EVENTOS,
                "id_evento" + SEP
                + "cant_dias" + SEP
                + "cantidad_participantes" + SEP
                + "nombre" + SEP
                + "detalles" + SEP
                + "estado" + SEP
                + "fecha" + SEP
                + "monto_persona"
        );

    }

    public static void guardar(Evento obj) throws IOException {

        obj.setIdEvento(obtenerSiguienteId());

        CSVUtility.escribirLinea(
                Constantes.ARCHIVO_EVENTOS,
                obj.toCSV()
        );
    }

    public static int obtenerSiguienteId() throws IOException {

        List<Evento> lista = listar();

        int max = 0;

        for (Evento e : lista) {
            if (e.getIdEvento() > max) {
                max = e.getIdEvento();
            }
        }

        return max + 1;
    }

    public static List<Evento> listar() throws IOException {

        List<Evento> lista = new ArrayList<>();

        List<String> lineas = CSVUtility.leerLineas(
                Constantes.ARCHIVO_EVENTOS
        );

        for (int i = 1; i < lineas.size(); i++) {
            lista.add(Evento.fromCSV(lineas.get(i)));
        }

        System.out.println(lista);

        return lista;
    }

    public static Evento buscarPorId(int idEvento) throws IOException {

        List<Evento> lista = listar();

        for (Evento e : lista) {
            if (e.getIdEvento() == idEvento) {
                return e;
            }
        }

        return null;
    }

    public static void eliminar(int idEvento) throws IOException {

        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_EVENTOS);
        List<String> nuevasLineas = new ArrayList<>();

        nuevasLineas.add(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {

            Evento e = Evento.fromCSV(lineas.get(i));

            if (e.getIdEvento() != idEvento) {
                nuevasLineas.add(lineas.get(i));
            }

        }

        CSVUtility.sobrescribirArchivo(
                Constantes.ARCHIVO_EVENTOS,
                nuevasLineas
        );
    }

    public static void actualizar(Evento actualizado) throws IOException {

        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_EVENTOS);
        List<String> nuevasLineas = new ArrayList<>();

        nuevasLineas.add(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {

            Evento e = Evento.fromCSV(lineas.get(i));

            if (e.getIdEvento() == actualizado.getIdEvento()) {
                nuevasLineas.add(actualizado.toCSV());
            } else {
                nuevasLineas.add(lineas.get(i));
            }

        }

        CSVUtility.sobrescribirArchivo(
                Constantes.ARCHIVO_EVENTOS,
                nuevasLineas
        );
    }

}
