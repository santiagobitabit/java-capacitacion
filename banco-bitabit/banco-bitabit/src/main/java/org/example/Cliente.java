package org.example;

public class Cliente implements Persona {
    String nombre;
    String apellido;
    int edad;
    String correo;
    String telefono;
    String domicilio;

    public Cliente (String nombre, String apellido, int edad, String correo, String telefono, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.domicilio = domicilio;
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

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
