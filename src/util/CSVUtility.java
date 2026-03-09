/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class CSVUtility {

    public static List<String> leerLineas(String archivo) throws IOException {

        List<String> lineas = new ArrayList<>();

        File file = new File(archivo);

        if (!file.exists()) {
            return lineas;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }

        return lineas;
    }

    public static void escribirLinea(String archivo, String linea) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {

            bw.write(linea);
            bw.newLine();

        }

    }

    public static void sobrescribirArchivo(String archivo, List<String> lineas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {

            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }

        }
    }

    public static void crearArchivo(String ruta, String header) throws IOException {

        File archivo = new File(ruta);

        // crear carpeta si no existe
        File parent = archivo.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }

        if (!archivo.exists()) {

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(header);
            bw.newLine();
            bw.close();
        }
    }

}
