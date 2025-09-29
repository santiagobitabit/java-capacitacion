package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.model.Cliente;
import com.bitabit.banco.domain.model.Cuenta;
import com.bitabit.banco.domain.model.TipoCuenta;
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
public class CuentaAdaptatorOut implements CuentaPortOut {

    private final JdbcTemplate jdbcTemplate;

    public CuentaAdaptatorOut(JdbcTemplate jdbcTemplate)  {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String save(Cuenta cuenta) {
        try {
            String sqlString = "insert into cuentas (tipo_cuenta,moneda, saldo, cbu, id_cliente) values (?,?,?,?,?)";
            jdbcTemplate.update(sqlString, cuenta.getTipoCuenta(), cuenta.getMoneda(), cuenta.getSaldo(), cuenta.getCbu(), cuenta.getId_cliente());
            return "Cuenta creado exitosamente";
        } catch (DataIntegrityViolationException e) {
            System.out.println("El cliente asociado no existe");
            return "El cliente asociado no existe";
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Cuenta> getByCBU(String cbu) {
        try {
            String sqlString = "SELECT id, tipo_cuenta, moneda, saldo, cbu, id_cliente FROM cuentas WHERE cbu = ?";
            Optional<Cuenta> cuenta = Optional.ofNullable(jdbcTemplate.queryForObject(sqlString, new CuentaRowMapper(), cbu));
            return cuenta;
        } catch (EmptyResultDataAccessException e){
            System.out.println("Cuenta no encontrada con cbu: " + cbu);
            return Optional.empty();
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cuenta> getAllByClienteId(int id_cliente) {
        return List.of();
    }

    @Override
    public void deleteByCBU(String cbu) {

    }

    public String update(int id, Cuenta cuenta) {
        try {
            String sqlString = "UPDATE cuentas SET tipo_cuenta = ?, saldo = ?, cbu = ?, id_cliente = ?  WHERE id = ?";
            jdbcTemplate.update(sqlString, cuenta.getTipoCuenta(), cuenta.getSaldo(), cuenta.getCbu(), cuenta.getId_cliente(), id);
            return "Cliente actualizado correctamente";
        } catch (DataIntegrityViolationException e) {
            System.out.println("El empleado asociado no existe");
            return "El empleado asociado no existe";
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static final class CuentaRowMapper implements RowMapper<Cuenta> {
        @Override
        public Cuenta mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cuenta cuenta = new Cuenta();
            cuenta.setId(rs.getInt("id"));
            cuenta.setTipoCuenta(rs.getString("tipo_cuenta"));
            cuenta.setMoneda(rs.getString("moneda"));
            cuenta.setCbu(rs.getString("cbu"));
            cuenta.setSaldo(rs.getDouble("saldo"));
            cuenta.setId_cliente(rs.getInt("id_cliente"));
            return cuenta;
        }
    }
}
