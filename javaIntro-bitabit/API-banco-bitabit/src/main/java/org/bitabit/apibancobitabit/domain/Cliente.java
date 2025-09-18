package org.bitabit.apibancobitabit.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class Cliente {
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String telefono;
    private String domicilio;
    private Empleado empleado;
    private String id_empleado;
}
