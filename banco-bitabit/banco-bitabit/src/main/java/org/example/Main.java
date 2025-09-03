package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Bienvenido al banco bitAbit");

        //Crear cliente
        Cliente cliente1 = new Cliente("Santiago", "Morelli", 35, "SM@mail.com", "5423221232", "calle 123");
        Cliente cliente2 = new Cliente("Patricio", "Rodriguez", 55, "PR@mail.com", "54556322", "calle 1432");

        //Crear empleado
        Empleado empleado1 = new Empleado("Pepe", "Gomez", 45,"PG@mail.com", "543234322",350);
        Empleado empleado2 = new Empleado("Federico", "Perez", 24,"FP@mail.com", "342424",750);

        //test linkedList
        System.out.println("Linked list");
        LinkedList<Persona> personas = new LinkedList<>();
        //los añado "desordenados" ordenandolo con los métodos del linked list.
        personas.add(empleado2);
        personas.addFirst(empleado1);
        personas.addLast(cliente2);
        personas.add(2,cliente1);

        Iterator<Persona> iterator_personas = personas.iterator();
        while (iterator_personas.hasNext()) {
            Persona persona = iterator_personas.next();
            System.out.println(persona.getNombre() + " " + persona.getApellido());
        }

        //test set && hashMap
        System.out.println("Set && hashmap tests");
        HashSet<String> nombres_list = new HashSet<String>();
        HashMap<String,String> map_personas = new HashMap<>();

        //Añado los id convertidos a String
        for (Persona persona : personas) {
            String nombre_apellido_telefono= persona.getNombre() + " " + persona.getApellido() + " - " + persona.getTelefono();
            String mail_telefono= persona.getEmail() + " - " + persona.getTelefono();
            nombres_list.add(nombre_apellido_telefono);
            map_personas.put(mail_telefono, nombre_apellido_telefono);
        }

        Iterator<String> iterator_nombres = nombres_list.iterator();
        for (Iterator<String> it = iterator_nombres; it.hasNext(); ) {
           System.out.println(it.next());
        }

        for(Map.Entry mEntry : map_personas.entrySet()){
            System.out.println("key: "+ mEntry.getKey() + " & Value: " + mEntry.getValue());
        }

        //Crear nueva cuenta
        Cuenta cuenta1 = new Cuenta(1,cliente1,empleado1,"pesos");
        Cuenta cuenta2 = new Cuenta(2,cliente1,empleado2,"pesos");
        Cuenta cuenta3 = new Cuenta(3,cliente2,empleado2,"pesos");

        //Ingresar dinero
        Deposito deposito = new Deposito(4500, cuenta1);
        Deposito deposito2 = new Deposito(500, cuenta3);

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

        test_arrayList(extraccion1, transferencia1);
        System.out.println("Fin");
//test push private 3
    }

    private static void test_arrayList(Extraccion extraccion1, Transferencia transferencia1) {
        System.out.println("Array list");
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

