package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmpleadoAdaptadorOut implements EmpleadosPortOut {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmpleadoAdaptadorOut(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Empleado empleado) {
        try {
            String sqlString = "insert into empleados (nombre, apellido, edad, correo, telefono, sueldo) values (?,?,?,?,?,?)";
            jdbcTemplate.update(sqlString, empleado.getNombre(), empleado.getApellido(), empleado.getEdad(), empleado.getCorreo(), empleado.getTelefono(), empleado.getSueldo());
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Empleado update(Empleado empleado) {
        try {
            String sqlString = "UPDATE empleados SET nombre = ?, apellido = ?, edad = ?, correo = ?, telefono = ?, sueldo = ? WHERE id = ?";
            jdbcTemplate.update(sqlString,empleado.getNombre(), empleado.getApellido(), empleado.getEdad(), empleado.getCorreo(), empleado.getTelefono(), empleado.getSueldo(), empleado.getId_empleado());
            return empleado;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            String sqlString = "DELETE FROM empleados WHERE id = ?";
            jdbcTemplate.update(sqlString, id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Empleado> getAll() {
        String sqlString = "SELECT id, nombre, apellido, edad, correo, telefono, sueldo FROM empleados";
        List listaEmpleados = jdbcTemplate.query(sqlString, new EmpleadoRowMapper());
        return listaEmpleados;
    }

    @Override
    public Empleado getById(String id) {
        String sqlString = "SELECT id, nombre, apellido, edad, correo, telefono, sueldo FROM empleados WHERE id = ?";
        Empleado empleado = jdbcTemplate.queryForObject(sqlString, new EmpleadoRowMapper(), id);
        return empleado;
    }

    private static final class EmpleadoRowMapper implements RowMapper<Empleado> {
        @Override
        public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
            Empleado empleado = new Empleado();
            empleado.setId_empleado(rs.getInt("id"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setEdad(rs.getInt("edad"));
            empleado.setCorreo(rs.getString("correo"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setSueldo(rs.getInt("sueldo"));
            return empleado;
        }
    }
}
