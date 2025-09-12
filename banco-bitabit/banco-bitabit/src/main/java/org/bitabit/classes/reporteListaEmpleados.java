package org.bitabit.classes;

import jdk.jfr.StackTrace;

import java.awt.print.PrinterIOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class reporteListaEmpleados {
    Banco banco;
    String base_path;

    public reporteListaEmpleados(Banco banco, String base_path) {
        this.banco = banco;
        this.base_path = base_path;
    }

    public void reporteListaEmpleados_total() throws IOException {
            String finalPath = this.base_path + "output/empleados_total.csv";
            List<Empleado> empleados = banco.getEmpleados();
            BufferedWriter bw = new BufferedWriter(new FileWriter(finalPath));

            for  (Empleado empleado : empleados) {
                bw.write(empleado.getNombre() +  "," + empleado.getApellido() + "," + empleado.getEdad() + ", " + empleado.getEmail() + ", " + empleado.getTelefono() + ", " + empleado.getSueldo());
                bw.newLine();
            }

            bw.flush();
    }

    public void reporteListaEmpleados_comisiones() throws IOException {
        String finalPath = this.base_path + "output/empleados_comisiones.csv";
        List<Empleado> empleados = banco.getEmpleados();
        BufferedWriter bw = new BufferedWriter(new FileWriter(finalPath));
        for  (Empleado empleado : empleados) {
            bw.write(empleado.getApellido() + ", " + empleado.getNombre() + ": " + empleado.getComision());
            bw.newLine();
        }
        bw.newLine();
        bw.write("---- Empleados Sin Comisiones ----");
        bw.newLine();
        empleados.stream()
                        .filter( empleado -> empleado.getComision() == 0)
                            .forEach(empleado -> {
                                    try {
                                        bw.write(empleado.getApellido() + ", " + empleado.getNombre());
                                        bw.newLine();
                                    } catch (IOException e) {
                                        System.out.println("Error al cargar el empleado");
                                    }
                                        });
        bw.flush();
    }
}
