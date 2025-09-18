package org.bitabit.apibancobitabit.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String telefono;
    private int sueldo;
    private double comision;
    private Empleado empleado;
}
