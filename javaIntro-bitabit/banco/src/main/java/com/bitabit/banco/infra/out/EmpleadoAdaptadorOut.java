package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.Empleado;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoAdaptadorOut implements EmpleadosPortOut {

    private JdbcTemplate jdbcTemplate;

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
    public Empleado update(int id, Empleado empleado) {
        try {
            String sqlString = "UPDATE empleados SET nombre = ?, apellido = ?, edad = ?, correo = ?, telefono = ?, sueldo = ? WHERE id_empleado = ?";
            jdbcTemplate.update(sqlString,empleado.getNombre(), empleado.getApellido(), empleado.getEdad(), empleado.getCorreo(), empleado.getTelefono(), empleado.getSueldo(), id);
            return empleado;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            String sqlString = "DELETE FROM empleados WHERE id_empleado = ?";
            jdbcTemplate.update(sqlString, id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Empleado> getAll() {
        String sqlString = "SELECT id_empleado, nombre, apellido, edad, correo, telefono, sueldo FROM empleados";
        List listaEmpleados = jdbcTemplate.query(sqlString, new EmpleadoRowMapper());
        return listaEmpleados;
    }

    @Override
    public Optional<Empleado> getById(int id) {
        try {
            String sqlString = "SELECT id_empleado, nombre, apellido, edad, correo, telefono, sueldo FROM empleados WHERE id_empleado = ?";
            Optional<Empleado> empleado = Optional.ofNullable(jdbcTemplate.queryForObject(sqlString, new EmpleadoRowMapper(), id));
            return empleado;
        } catch (EmptyResultDataAccessException e){
            System.out.println("No se encuentra empleado con id:" + id);
            return Optional.empty();
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static final class EmpleadoRowMapper implements RowMapper<Empleado> {
        @Override
        public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
            Empleado empleado = new Empleado();
            empleado.setId_empleado(rs.getInt("id_empleado"));
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
