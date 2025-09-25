package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteAdaptatorOut implements ClientePortOut {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClienteAdaptatorOut(JdbcTemplate jdbcTemplate)  {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Cliente cliente) {
        try {
            String sqlString = "insert into clientes (nombre, apellido, edad, correo, telefono, domicilio) values (?,?,?,?,?,?)";
            jdbcTemplate.update(sqlString, cliente.getNombre(), cliente.getApellido(), cliente.getEdad(), cliente.getCorreo(), cliente.getTelefono(), cliente.getDomicilio());
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public Cliente update(int id, Cliente cliente) {
        try {
            String sqlString = "UPDATE clientes SET nombre = ?, apellido = ?, edad = ?, correo = ?, telefono = ?, domicilio = ? WHERE id = ?";
            jdbcTemplate.update(sqlString,cliente.getNombre(), cliente.getApellido(), cliente.getEdad(), cliente.getCorreo(), cliente.getTelefono(), cliente.getDomicilio(), id);
            return cliente;
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        try {
            String sqlString = "DELETE FROM clientes WHERE id = ?";
            jdbcTemplate.update(sqlString, id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Cliente> getAll() {
        String sqlString = "SELECT id, nombre, apellido, edad, correo, telefono, sueldo FROM clientes";
        List listaClientes = jdbcTemplate.query(sqlString, new ClienteRowMapper());
        return listaClientes;
    }

    @Override
    public Cliente getById(int id) {
        String sqlString = "SELECT id, nombre, apellido, edad, correo, telefono, sueldo FROM clientes WHERE id = ?";
        Cliente cliente = jdbcTemplate.queryForObject(sqlString, new ClienteRowMapper(), id);
        return cliente;
    }

    private static final class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setId_cliente(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setEdad(rs.getInt("edad"));
            cliente.setCorreo(rs.getString("correo"));
            cliente.setTelefono(rs.getString("telefono"));
            return cliente;
        }
    }
}