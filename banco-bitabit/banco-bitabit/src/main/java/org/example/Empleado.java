package org.example;

public class Empleado implements Persona {
    String nombre;
    String apellido;
    int edad;
    String correo;
    String telefono;
    int sueldo;
    double comision;

    public Empleado (String nombre, String apellido, int edad, String correo, String telefono, int sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.comision = 0;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public void setEmail(String email) {
        this.correo = email;
    }

    @Override
    public String getEmail() {
        return this.correo;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public int getEdad() {
        return this.edad;
    }

    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return this.sueldo;
    }

    public void setComision(int monto) {
        this.comision = monto * 0.1;;
    }

    public double getComision() {
        return this.comision;
    }
}
