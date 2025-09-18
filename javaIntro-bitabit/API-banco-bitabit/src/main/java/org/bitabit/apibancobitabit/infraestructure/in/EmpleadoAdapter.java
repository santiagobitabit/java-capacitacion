package org.bitabit.apibancobitabit.infraestructure.in;

import org.bitabit.apibancobitabit.domain.Empleado;


public class EmpleadoAdapter implements EmpleadoInputPort {
    public EmpleadoAdapter() {
    }
    public EmpleadoAdapter(Empleado empleado) {}

    @Override
    public void CreateEmpleado(String nombre, String apellido, int edad, String correo, String telefono, int sueldo) {

    }

    @Override
    public void DeleteEmpleado(String id) {

    }

    @Override
    public Empleado GetByIdEmpleado(String id) {
        return null;
    }
}
