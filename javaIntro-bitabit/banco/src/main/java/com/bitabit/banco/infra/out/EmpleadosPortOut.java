package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.Empleado;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface EmpleadosPortOut {
    public void save(Empleado empleado);
    public Empleado update(int id, Empleado empleado);
    public void deleteById(int id);
    public List<Empleado> getAll();
    public Optional<Empleado> getById(int id);
}