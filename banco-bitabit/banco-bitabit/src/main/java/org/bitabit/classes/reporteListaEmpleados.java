package org.bitabit.classes;

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
        try {
            String finalPath = this.base_path + "empleados_total.csv";
            List<Empleado> empleados = banco.getEmpleados();
            BufferedWriter bw = new BufferedWriter(new FileWriter(finalPath));

            for  (Empleado empleado : empleados) {
                bw.write(empleado.getNombre() +  "," + empleado.getApellido() + "," + empleado.getEdad() + ", " + empleado.getEmail() + ", " + empleado.getTelefono() + ", " + empleado.getSueldo());
                bw.newLine();
            }

            bw.flush();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
