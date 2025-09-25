package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.Empleado;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmpleadosPortOut {
    public void save(Empleado empleado);
    public Empleado update(Empleado empleado);
    public void deleteById(String id);
    public List<Empleado> getAll();
    public Empleado getById(@RequestParam String id);
}