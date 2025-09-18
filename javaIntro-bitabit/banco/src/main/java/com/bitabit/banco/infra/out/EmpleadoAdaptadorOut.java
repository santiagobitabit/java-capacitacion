package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoAdaptadorOut implements EmpleadosPortOut {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmpleadoAdaptadorOut(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Empleado empleado) {
        String sqlString = "insert into empleados (nombre, apellido, edad, correo, telefono, sueldo) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sqlString, empleado.getNombre(), empleado.getApellido(), empleado.getEdad(), empleado.getCorreo(), empleado.getTelefono(), empleado.getSueldo());
    }
}
