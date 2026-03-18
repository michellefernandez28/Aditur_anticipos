/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Cliente_X_Evento;
import util.CSVUtility;
import util.Constantes;
import static util.Constantes.SEP;

/**
 *
 * @author Usuario
 */
public class ClienteDAO {

    public static void inicializarArchivo() throws IOException {

        CSVUtility.crearArchivo(
                Constantes.ARCHIVO_CLIENTES,
                "cedula" + SEP
                + "nombre" + SEP
                + "apellidos"
        );

    }

    //COREGIR con VALIDACIÓN
    public static void guardar(Cliente obj) throws IOException {

        CSVUtility.escribirLinea(
                Constantes.ARCHIVO_CLIENTES,
                obj.toCSV()
        );
    }

    public static List<Cliente> listarXEvento(int idEvento) throws IOException {

        List<Cliente> resultado = new ArrayList<>();

        // 1. Obtener inscripciones del evento
        List<Cliente_X_Evento> inscripciones
                = ClienteXEventoDAO.buscarPorEvento(idEvento);

        // 2. Extraer las cédulas inscritas
        List<Integer> cedulas = new ArrayList<>();
        for (Cliente_X_Evento cxe : inscripciones) {
            cedulas.add(cxe.getCedula());
        }

        // 3. Leer archivo de clientes
        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_CLIENTES);

        for (int i = 1; i < lineas.size(); i++) {

            Cliente cliente = Cliente.fromCSV(lineas.get(i));

            // 4. Filtrar por las cédulas del evento
            if (cedulas.contains(cliente.getCedula())) {
                resultado.add(cliente);
            }
        }

        return resultado;
    }

    public static void eliminar(int cedula) throws IOException {

        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_CLIENTES);
        List<String> nuevasLineas = new ArrayList<>();

        nuevasLineas.add(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {

            Cliente c = Cliente.fromCSV(lineas.get(i));

            if (c.getCedula() != cedula) {
                nuevasLineas.add(lineas.get(i));
            }

        }

        CSVUtility.sobrescribirArchivo(
                Constantes.ARCHIVO_CLIENTES,
                nuevasLineas
        );
    }

    public static void actualizar(int cedula, Cliente actualizado) throws IOException {

        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_CLIENTES);
        List<String> nuevasLineas = new ArrayList<>();

        nuevasLineas.add(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {

            Cliente c = Cliente.fromCSV(lineas.get(i));

            if (c.getCedula() == cedula) {
                nuevasLineas.add(actualizado.toCSV());
            } else {
                nuevasLineas.add(lineas.get(i));
            }

        }

        CSVUtility.sobrescribirArchivo(
                Constantes.ARCHIVO_CLIENTES,
                nuevasLineas
        );
    }

    public static boolean existe(int cedula, int idEvento) throws IOException {

        List<Cliente> lista = listarXEvento(idEvento);

        for (Cliente c : lista) {
            if (c.getCedula() == cedula) {
                return true;
            }
        }

        return false;
    }

    public static Cliente buscarXCedula(int cedula) throws IOException {

        List<String> lineas = CSVUtility.leerLineas(Constantes.ARCHIVO_CLIENTES);

        for (int i = 1; i < lineas.size(); i++) {
            Cliente cliente = Cliente.fromCSV(lineas.get(i));

            if (cedula == cliente.getCedula()) {
                return cliente;
            }
        }

        return null; // 🔥 importante
    }
}
