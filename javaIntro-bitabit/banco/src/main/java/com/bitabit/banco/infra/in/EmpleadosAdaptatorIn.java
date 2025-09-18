package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.Empleado;
import com.bitabit.banco.infra.out.EmpleadoAdaptadorOut;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleados/")
public class EmpleadosAdaptatorIn implements EmpleadosPortIn {

    private final EmpleadoAdaptadorOut empleadoAdaptadorOut;

    public EmpleadosAdaptatorIn(EmpleadoAdaptadorOut empleadoAdaptadorOut) {
        this.empleadoAdaptadorOut = empleadoAdaptadorOut;
    }

    @PostMapping("/nuevo")
    public void newEmpleado(@RequestBody Empleado empleado) {
        empleadoAdaptadorOut.save(empleado);
    }
}
