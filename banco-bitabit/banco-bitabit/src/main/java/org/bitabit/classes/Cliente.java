package org.bitabit.classes;

import java.util.Random;
import org.bitabit.interfaces.Persona;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Persona {
    String nombre;
    String apellido;
    int edad;
    String correo;
    String telefono;
    String domicilio;
    Empleado empleado;
    String id_empleado;
    Banco banco;
    List<Cuenta> cuentas = new ArrayList<Cuenta>();

    public Cliente (String nombre, String apellido, int edad, String correo, String telefono, String domicilio, Banco banco) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.empleado = banco.getEmpleados().get(id_list_empleado_random(0, (banco.getEmpleados().size() - 1)));
        this.banco = banco;
        banco.addCliente(this);
    }
    static int id_list_empleado_random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    public void addCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
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

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmplead_nombre() {
        return this.empleado.getNombre() + " " + this.empleado.getApellido();
    }
}
