/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Pago;
import util.CSVUtility;
import util.Constantes;
import static util.Constantes.SEP;

/**
 *
 * @author Usuario
 */
public class PagoDAO {

    public static void inicializarArchivo() throws IOException {

        CSVUtility.crearArchivo(
                Constantes.ARCHIVO_PAGOS,
                "id_pago" + SEP + "fecha" + SEP + "monto" + SEP + "cedula" + SEP + "id_evento"
        );

    }

    public static void guardar(Pago obj) throws IOException {

        CSVUtility.escribirLinea(
                Constantes.ARCHIVO_PAGOS,
                obj.toCSV()
        );

    }

    public static int obtenerSiguienteId() throws IOException {

        List<Pago> lista = listar();

        int max = 0;

        for (Pago p : lista) {
            if (p.getId_pago() > max) {
                max = p.getId_pago();
            }
        }

        return max + 1;
    }

    public static List<Pago> listar() throws IOException {

        List<Pago> lista = new ArrayList<>();

        List<String> lineas = CSVUtility.leerLineas(
                Constantes.ARCHIVO_PAGOS
        );

        for (int i = 1; i < lineas.size(); i++) {
            lista.add(Pago.fromCSV(lineas.get(i)));
        }

        return lista;
    }

    public static void eliminar(int cedula, int idEvento) throws IOException {
        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_PAGOS);

        List<String> nuevasLineas = new ArrayList<>();

        nuevasLineas.add(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {
            Pago p = Pago.fromCSV(lineas.get(i));
            if (!(p.getCedula() == cedula && p.getId_evento() == idEvento)) {
                nuevasLineas.add(lineas.get(i));
            }

        }

        CSVUtility.sobrescribirArchivo(Constantes.ARCHIVO_PAGOS, nuevasLineas);
    }

    public static void actualizar(Pago actualizado) throws IOException {

        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_PAGOS);
        List<String> nuevasLineas = new ArrayList<>();

        nuevasLineas.add(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {
            Pago p = Pago.fromCSV(lineas.get(i));
            if (p.getCedula() == actualizado.getCedula() && p.getId_evento() == actualizado.getId_evento()) {
                nuevasLineas.add(actualizado.toCSV());
            } else {
                nuevasLineas.add(lineas.get(i));
            }

        }

        CSVUtility.sobrescribirArchivo(Constantes.ARCHIVO_PAGOS, nuevasLineas);
    }

    public static List<Pago> buscarPorCedulaYEvento(int cedula, int idEvento) throws IOException {

        List<Pago> resultado = new ArrayList<>();

        List<Pago> lista = listar();

        for (Pago p : lista) {
            if (p.getCedula() == cedula && p.getId_evento() == idEvento) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public static List<Pago> buscarPorCedula(int cedula) throws IOException {
        List<Pago> resultado = new ArrayList<>();
        List<Pago> lista = listar();
        for (Pago p : lista) {
            if (p.getCedula() == cedula) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public static List<Pago> buscarPorEvento(int idEvento) throws IOException {
        List<Pago> resultado = new ArrayList<>();
        List<Pago> lista = listar();
        for (Pago p : lista) {
            if (p.getId_evento() == idEvento) {
                resultado.add(p);
            }
        }
        return resultado;
    }

}
