package com.bitabit.banco.domain.model;


import org.springframework.stereotype.Component;

@Component
public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String telefono;
    private int sueldo;
    private double comision;

    public int getId_empleado() {
        return id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getSueldo() {
        return sueldo;
    }

    public double getComision() {
        return comision;
    }


    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}
