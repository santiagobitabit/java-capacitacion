package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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


    public String save(Cliente cliente) {
        try {
            System.out.println("Cliente a gusradar: " + cliente.getApellido() + " - " + cliente.getId_empleado());
            String sqlString = "insert into clientes (nombre, apellido, edad, correo, telefono, domicilio, id_empleado) values (?,?,?,?,?,?,?)";
            jdbcTemplate.update(sqlString, cliente.getNombre(), cliente.getApellido(), cliente.getEdad(), cliente.getCorreo(), cliente.getTelefono(), cliente.getDomicilio(), cliente.getId_empleado());
            return "Cliente creado exitosamente";
        } catch (DataIntegrityViolationException e) {
            System.out.println("El empleado asociado no existe");
            return "El empleado asociado no existe";
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public String update(int id, Cliente cliente) {
        try {
            String sqlString = "UPDATE clientes SET nombre = ?, apellido = ?, edad = ?, correo = ?, telefono = ?, domicilio = ?, id_empleado = ? WHERE id_cliente = ?";
            jdbcTemplate.update(sqlString, cliente.getNombre(), cliente.getApellido(), cliente.getEdad(), cliente.getCorreo(), cliente.getTelefono(), cliente.getDomicilio(), cliente.getId_empleado(), id);
            return "Cliente actualizado correctamente";
        } catch (DataIntegrityViolationException e) {
            System.out.println("El empleado asociado no existe");
            return "El empleado asociado no existe";
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        try {
            String sqlString = "DELETE FROM clientes WHERE id_cliente = ?";
            jdbcTemplate.update(sqlString, id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Cliente> getAll() {
        String sqlString = "SELECT id_cliente, nombre, apellido, edad, correo, telefono, domicilio, id_empleado FROM clientes";
        List<Cliente> listaClientes = jdbcTemplate.query(sqlString, new ClienteRowMapper());
        return listaClientes;
    }

    @Override
    public Optional<Cliente> getById(int id) {
        try {
            String sqlString = "SELECT id_cliente, nombre, apellido, edad, correo, telefono, domicilio, id_empleado FROM clientes WHERE id_cliente = ?";
            Optional<Cliente> cliente = Optional.ofNullable(jdbcTemplate.queryForObject(sqlString, new ClienteRowMapper(), id));
            return cliente;
        } catch (EmptyResultDataAccessException e){
            System.out.println("Cliente no encontrado con id: " + id);
            return Optional.empty();
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static final class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setId_cliente(rs.getInt("id_cliente"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setEdad(rs.getInt("edad"));
            cliente.setCorreo(rs.getString("correo"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setDomicilio(rs.getString("domicilio"));
            cliente.setId_empleado(rs.getInt(("id_empleado")));
            return cliente;
        }
    }
}