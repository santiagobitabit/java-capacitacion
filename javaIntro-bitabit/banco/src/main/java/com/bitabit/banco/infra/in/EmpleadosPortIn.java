package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.Empleado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface EmpleadosPortIn {
    public ResponseEntity<Empleado> newEmpleado(Empleado empleado);

    public ResponseEntity<Empleado> getEmpleadoById(String id);

    public ResponseEntity<List<Empleado>> getAllEmpleados();

    public ResponseEntity<Object> deleteEmpleadoById(String id);

    public ResponseEntity<Empleado> updateEmpleadoById(String id, Empleado empleado);
}
