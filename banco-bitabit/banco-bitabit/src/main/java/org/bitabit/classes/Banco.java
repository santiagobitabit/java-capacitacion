package org.bitabit.classes;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    String nombre;
    List<Cliente> clientes;
    List<Empleado> empleados;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<Cliente>();
        this.empleados = new ArrayList<Empleado>();
    }

    public void addCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void addEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }

    public String getClientes_names() {
        Iterator<Cliente> iterator = this.clientes.iterator();
        String lista_cliente = "";
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            lista_cliente += cliente.getNombre() + " " + cliente.getApellido() + " // ";
        }
        return lista_cliente;
    }

    public List<Cliente> getCliente(){
        return this.clientes;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }
}
