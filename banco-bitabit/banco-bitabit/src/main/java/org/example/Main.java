package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Bienvenido al banco bitAbit");
        //Crear cliente
        Cliente cliente1 = new Cliente("Santiago", "Morelli", 35, "SM@mail.com", "5423221232", "calle 123");
        //Crear empleado
        Empleado empleado1 = new Empleado("Pepe", "Gomez", 45,"PG@mail.com", "543234322",350);
        //Crear nueva cuenta
        Cuenta cuenta1 = new Cuenta(1,cliente1,empleado1,"pesos");
        Cuenta cuenta2 = new Cuenta(2,cliente1,empleado1,"pesos");
        //Ingresar dinero
        cuenta1.setSaldo(4500);
        //Hacer una extraccion de un cliente a cargo de un empleado
        Extraccion extraccion1 = new Extraccion(500,cuenta1);
        //Hacer transferencia
        Transferencia transferencia1 = new Transferencia(1500,cuenta1,cuenta2);
        //Solo para mostrar polimorfismo
        System.out.println(transferencia1.isValid());
        System.out.println(extraccion1.isValid());
        //mostrar resultados
        System.out.println("Saldo final cuenta1: " + cuenta1.getSaldo());
        System.out.println("Saldo final cuenta2: " + cuenta2.getSaldo());
        System.out.println("Comision empleado1: " + empleado1.getComision());

        printData_total(extraccion1, transferencia1);
        System.out.println("Fin");

    }

    private static void printData_total(Extraccion extraccion1, Transferencia transferencia1) {
        ArrayList<Operacion> operaciones = new ArrayList<>();
        operaciones.add(extraccion1);
        operaciones.add(transferencia1);
        int monto_total = 0;
        for (Operacion operacion : operaciones) {
            if (operacion.isValid()) {
                monto_total += operacion.getMonto();
            }
        }
        System.out.println(monto_total);
    }
}