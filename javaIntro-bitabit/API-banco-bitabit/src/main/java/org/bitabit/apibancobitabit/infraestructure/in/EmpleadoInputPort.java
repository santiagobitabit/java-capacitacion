package org.bitabit.apibancobitabit.infraestructure.in;

import org.bitabit.apibancobitabit.domain.Empleado;

public interface EmpleadoInputPort {
    public void CreateEmpleado(String nombre, String apellido, int edad, String correo, String telefono, int sueldo);
    public void DeleteEmpleado(String id);
    public Empleado GetByIdEmpleado(String id);
}
