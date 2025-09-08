package org.bitabit.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class dataClientesBulk {
    Banco banco;

        public dataClientesBulk(Banco banco){
            this.banco = banco;
        }

        public void ingresarClientesCsv(String path){

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
                throw new RuntimeException(e);
            } finally {
                System.out.println("Bloque finally - ingresarClientesCsv");
            }
        }


    }
