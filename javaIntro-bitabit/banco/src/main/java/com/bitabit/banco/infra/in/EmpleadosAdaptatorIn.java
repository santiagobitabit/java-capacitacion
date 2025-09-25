package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.Empleado;
import com.bitabit.banco.infra.out.EmpleadoAdaptadorOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados/")
public class EmpleadosAdaptatorIn implements EmpleadosPortIn {

    private final EmpleadoAdaptadorOut empleadoAdaptadorOut;

    public EmpleadosAdaptatorIn(EmpleadoAdaptadorOut empleadoAdaptadorOut) {
        this.empleadoAdaptadorOut = empleadoAdaptadorOut;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Empleado> newEmpleado(@RequestBody Empleado empleado) {
        empleadoAdaptadorOut.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @GetMapping("/:id")
    public ResponseEntity<Empleado> getEmpleadoById(@RequestParam String id) {
        Empleado empleado = empleadoAdaptadorOut.getById(id);
        return ResponseEntity.ok().body(empleado);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List listaEmpleados = empleadoAdaptadorOut.getAll();
        return ResponseEntity.ok().body(listaEmpleados);
    }

    @DeleteMapping("/borrar/:id")
    public ResponseEntity<Object> deleteEmpleadoById(@RequestParam String id) {
        empleadoAdaptadorOut.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/actualizar/:id")
    public ResponseEntity<Empleado> updateEmpleadoById(@RequestParam String id, @RequestBody Empleado empleado) {
        Empleado empleadoActualizado = empleadoAdaptadorOut.update(empleado);
        return ResponseEntity.ok().body(empleadoActualizado);
    }
}
