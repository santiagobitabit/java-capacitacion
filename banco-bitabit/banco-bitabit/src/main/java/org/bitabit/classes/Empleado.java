package org.bitabit.classes;

import org.bitabit.interfaces.Persona;
import org.bitabit.exceptions.EmpleadoFueraDeRangoEtario;

import java.util.ArrayList;
import java.util.List;

public class Empleado implements Persona {
    private int id_empleado;
    String nombre;
    String apellido;
    int edad;
    String correo;
    String telefono;
    int sueldo;
    double comision;
    Banco banco;
    List<Cliente> clientes = new ArrayList<Cliente>();

    public Empleado (String nombre, String apellido, int edad, String correo, String telefono, int sueldo, Banco banco) {
        if (edad < 18) { throw new EmpleadoFueraDeRangoEtario("La edad debe ser mayor a 18"); }
        if (edad > 55) { throw new EmpleadoFueraDeRangoEtario("La edad debe ser menor a 56"); }

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.comision = 0;
        this.banco = banco;
        banco.addEmpleado(this);
    }

    public int getId_empleado() { return this.id_empleado; }

    public void setId_empleado(int id_empleado) { this.id_empleado = id_empleado; }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setEmail(String email) {
        this.correo = email;
    }

    public String getEmail() {
        return this.correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String getDomicilio() {
        return "";
    }

    @Override
    public void setDomicilio(String domicilio) {

    }

    public void setSueldo(int sueldo) { this.sueldo = sueldo; }

    public int getSueldo() {
        return this.sueldo;
    }

    public void setComision(int monto) {
        this.comision = monto * 0.1;;
    }

    public void setComisionTotal(double comision) {
        this.comision = comision;;
    }

    public double getComision() {
        return this.comision;
    }
}
