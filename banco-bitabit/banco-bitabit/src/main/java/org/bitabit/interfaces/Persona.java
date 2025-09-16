package org.bitabit.interfaces;

import org.bitabit.classes.Banco;
import org.bitabit.classes.Cuenta;
import org.bitabit.classes.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Persona {

    public void setNombre(String nombre);

    public String getNombre();
    public void setApellido(String apellido);

    public String getApellido();

    public void setEmail(String email);

    public String getEmail();

    public void setTelefono(String telefono);

    public String getTelefono();

    public int getEdad();

    public void setEdad(int edad) ;

    public String getDomicilio();

    public void setDomicilio(String domicilio) ;

}
