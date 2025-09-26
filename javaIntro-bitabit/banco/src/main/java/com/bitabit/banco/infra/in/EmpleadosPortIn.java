package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.Empleado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public interface EmpleadosPortIn {
    public ResponseEntity<Empleado> newEmpleado(Empleado empleado);

    public ResponseEntity<Optional<Empleado>> getEmpleadoById(int id);

    public ResponseEntity<List<Empleado>> getAllEmpleados();

    public ResponseEntity<Object> deleteEmpleadoById(int id);

    public ResponseEntity<Empleado> updateEmpleadoById(int id, Empleado empleado);
}
