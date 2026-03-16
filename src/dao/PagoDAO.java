/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
                Constantes.ARCHIVO_CLIENTE_EVENTO,
                "id_pago" + SEP + "fecha" + SEP + "monto" + SEP + "cedula" + SEP + "id_evento"
        );

    }

}
