package org.bitabit;

import org.bitabit.classes.*;
import org.bitabit.enums.Moneda;
import org.bitabit.classes.Transferencia;
import org.bitabit.interfaces.Persona;
import org.bitabit.interfaces.inputConsola;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Bienvenido al banco bitAbit");

        Banco banco = new Banco("Bitabit");
        String base_path = System.getProperty("user.dir") + "/src/main/resources/";
        System.out.println(base_path);
//        contratistaTMP();
//        String testInoput = inputFromConsole();
//        System.out.println(testInoput);
        dataEmpleadosBulk inputBulk_empleados = new dataEmpleadosBulk(banco);
        inputBulk_empleados.ingresarEmpleadosCsv(base_path + "input/empleados.csv");
////
        dataClientesBulk testReadFile = new dataClientesBulk(banco);
//        byte [] imageInByte =  testReadFile.ingresarImagenClientesBin(base_path + "input/testBin.bin");
//        testReadFile.descargarImagenClienteBin(imageInByte,base_path + "output/ImageBin.bin");
        testReadFile.ingresarClientesCsv(base_path + "input/clientes.csv");
//
//        dataClientesBulk inputImageBin = new dataClientesBulk(banco);
//        for (Cliente cliente : banco.getCliente()) {
//            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + " - " + cliente.getEmplead_nombre() + " // ");
//        }
//
        //Crear nueva cuenta
        Cuenta cuenta1 = new Cuenta(1,banco.getCliente().getFirst(), Moneda.PESO);
        Cuenta cuenta2 = new Cuenta(2,banco.getCliente().getFirst(),Moneda.PESO);
        Cuenta cuenta3 = new Cuenta(3,banco.getCliente().getLast(),Moneda.EURO);

        //depositosConcurrentes(cuenta1);
        depositosConcurrentesExecutor(cuenta1);
//
//        System.out.println(banco.getCliente().getFirst().getCuentas().getFirst().getId());
//        System.out.println(banco.getCliente().getFirst().getCuentas().getLast().getId());
//
//        //Ingresar dinero
//        Deposito deposito = new Deposito(5500, cuenta1);
//        Deposito deposito2 = new Deposito(500, cuenta3);
//
//        //Hacer una extraccion de un cliente a cargo de un empleado
//        Extraccion extraccion1 = new Extraccion(500,cuenta1);
//        //Hacer transferencia
//        Transferencia transferencia1 = new Transferencia(1500,cuenta1,cuenta2);
//
//        //mostrar resultados
//        System.out.println("Saldo final cuenta1: " + cuenta1.getSaldo());
//        System.out.println("Saldo final cuenta2: " + cuenta2.getSaldo());
//        System.out.println("Comision empleado1: " + banco.getEmpleados().getFirst().getComision());
//
//        //Imprimir lista
//        print_listaClientes_porEmpleado(banco.getEmpleados().getFirst());
//
//        reporteListaEmpleados reporteListaEmpleados = new reporteListaEmpleados(banco, base_path);
//        reporteListaEmpleados.reporteListaEmpleados_total();
//        reporteListaEmpleados.reporteListaEmpleados_comisiones();
        System.out.println("Fin");
    }

    private static void print_listaClientes_porEmpleado(Empleado empleado) {
        for (Cliente cliente : empleado.getClientes()) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido());
        }
    }

    public static void contratistaTMP(){
        new Persona(){
            String nombre;

            @Override
            public void setNombre(String nombre) {
                System.out.println(nombre);
            }

            public String getNombre() {
                return this.nombre;
            }

            @Override
            public void setApellido(String apellido) {

            }

            @Override
            public String getApellido() {
                return "";
            }

            @Override
            public void setEmail(String email) {

            }

            @Override
            public String getEmail() {
                return "";
            }

            @Override
            public void setTelefono(String telefono) {

            }

            @Override
            public String getTelefono() {
                return "";
            }

            @Override
            public int getEdad() {
                return 0;
            }

            @Override
            public void setEdad(int edad) {

            }
        }.setNombre("test");
    }

    private static String inputFromConsole(){
        inputConsola consola = () -> {
            Scanner sc = new Scanner(System.in);
            return  sc.nextLine();
        };
        return consola.input();
    }

    public static void depositosConcurrentes(Cuenta cuenta){
        System.out.println("Iniciando threads");
        try{
                Thread thread = new Thread(new DepositosWithThreads(2, cuenta));
                Thread thread2 = new Thread(new DepositosWithThreads(2, cuenta));
                thread2.start();
                thread2.join();
                thread.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Se terminó thread.");
            System.out.println("Saldo final cuenta1: " + cuenta.getSaldo());
        }
    }

    public static void depositosConcurrentesExecutor(Cuenta cuenta){
        System.out.println("Iniciando threads con exdecutors");
        var service = Executors.newSingleThreadExecutor();
        service.submit(new DepositosWithThreads(2,cuenta));
        service.submit(new DepositosWithThreads(2,cuenta));

        service.shutdown();
        System.out.println("Saldo final cuenta1: " + cuenta.getSaldo());
    }
}