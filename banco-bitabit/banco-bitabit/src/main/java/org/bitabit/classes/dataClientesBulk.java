package org.bitabit.classes;

import java.awt.print.PrinterIOException;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class dataClientesBulk {
    Banco banco;

    public dataClientesBulk(Banco banco) {
        this.banco = banco;
    }

    public void ingresarClientesCsv(String path) {

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                // System.out.println(linea);
                List<String> lista = Arrays.asList(linea.split(";"));
                new Cliente(lista.get(0), lista.get(1),Integer.parseInt(lista.get(2)), lista.get(3), lista.get(4), lista.get(5), this.banco);
                linea = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("Error en el archivo");
        } finally {
            System.out.println("Bloque finally - ingresarClientesCsv");
        }
    }


    public byte[] ingresarImagenClientesBin(String path) throws FileNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(path);
            byte[] imageInBytes = fis.readAllBytes();
            fis.close();
            return imageInBytes;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fallo la carga del archivo");
            return null;
        }
    }

    public void descargarImagenClienteBin(byte[] imagenClienteBytes, String path) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(path, true);
            fos.write(imagenClienteBytes);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fallo la descarga del archivo");
        }
    }
}

