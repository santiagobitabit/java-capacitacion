package org.bitabit;

import org.bitabit.classes.*;
import org.bitabit.enums.Moneda;
import org.bitabit.classes.Transferencia;

import java.io.IOException;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Bienvenido al banco bitAbit");
        Banco banco = new Banco("Bitabit");
        String base_path = System.getProperty("user.dir") + "/src/main/resources/";
        System.out.println(base_path);
        dataEmpleadosBulk inputBulk_empleados = new dataEmpleadosBulk(banco);
        inputBulk_empleados.ingresarEmpleadosCsv("/home/santi-morelli/SM/DesarrolloWeb/JAVA/javaIntro-bitabit/java-capacitacion/banco-bitabit/banco-bitabit/src/main/resources/empleados.csv");

        dataClientesBulk testReadFile = new dataClientesBulk(banco);
        testReadFile.ingresarClientesCsv("/home/santi-morelli/SM/DesarrolloWeb/JAVA/javaIntro-bitabit/java-capacitacion/banco-bitabit/banco-bitabit/src/main/resources/clientes.csv");

        for (Cliente cliente : banco.getCliente()) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + " - " + cliente.getEmplead_nombre() + " // ");
        }

        //Crear nueva cuenta
        Cuenta cuenta1 = new Cuenta(1,banco.getCliente().getFirst(), Moneda.PESO);
        Cuenta cuenta2 = new Cuenta(2,banco.getCliente().getFirst(),Moneda.PESO);
        Cuenta cuenta3 = new Cuenta(3,banco.getCliente().getLast(),Moneda.EURO);

        System.out.println(banco.getCliente().getFirst().getCuentas().getFirst().getId());
        System.out.println(banco.getCliente().getFirst().getCuentas().getLast().getId());

        //Ingresar dinero
        Deposito deposito = new Deposito(5500, cuenta1);
        Deposito deposito2 = new Deposito(500, cuenta3);

        //Hacer una extraccion de un cliente a cargo de un empleado
        Extraccion extraccion1 = new Extraccion(500,cuenta1);
        //Hacer transferencia
        Transferencia transferencia1 = new Transferencia(1500,cuenta1,cuenta2);

        //mostrar resultados
        System.out.println("Saldo final cuenta1: " + cuenta1.getSaldo());
        System.out.println("Saldo final cuenta2: " + cuenta2.getSaldo());
        System.out.println("Comision empleado1: " + banco.getEmpleados().getFirst().getComision());

        //Imprimir lista
        print_listaClientes_porEmpleado(banco.getEmpleados().getFirst());

        reporteListaEmpleados reporteListaEmpleados = new reporteListaEmpleados(banco, base_path);
        reporteListaEmpleados.reporteListaEmpleados_total();
        System.out.println("Fin");
    }

    private static void print_listaClientes_porEmpleado(Empleado empleado) {
        for (Cliente cliente : empleado.getClientes()) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido());
        }
    }
}