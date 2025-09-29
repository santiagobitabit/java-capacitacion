package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.model.Transaccion;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TransaccionAdaptatorOut implements TransaccionPortOut {

    private JdbcTemplate jdbcTemplate;
    private Transaccion transaccionClass;

    public TransaccionAdaptatorOut(JdbcTemplate jdbcTemplate, Transaccion transaccionClass) {

        this.jdbcTemplate = jdbcTemplate;
        this.transaccionClass = transaccionClass;
    };

    @Override
    public String save(Transaccion transaccion) {
        try {
            String sqlString = "insert into transacciones (id_cliente, monto, fecha, cbu_cuenta_destino, cbu_cuenta_origen, error_durante_transaccion) values (?,?,?,?,?,?)";
            jdbcTemplate.update(sqlString, transaccion.getId_cliente(), transaccion.getMonto(), transaccion.getFecha(), transaccion.getCbuCuentaDestino(), transaccion.getCbuCuentaOrigen(), transaccion.getErrorDuranteTransaccion());
            return "Transaccion guardada exitosamente";
        } catch (DataIntegrityViolationException e) {
            System.out.println("El cliente asociado no existe");
            return "El cliente asociado no existe";
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Transaccion> getAllByClienteId(int id_cliente) {
        String sql = "SELECT * FROM transacciones WHERE id_cliente = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{id_cliente}, (rs, rowNum) -> {
                Transaccion transaccion = this.transaccionClass;
                transaccion.setId(rs.getInt("id"));
                transaccion.setId_cliente(rs.getInt("id_cliente"));
                transaccion.setMonto(rs.getDouble("monto"));
                transaccion.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                transaccion.setCbuCuentaDestino(rs.getString("cbu_cuenta_destino"));
                transaccion.setCbuCuentaOrigen(rs.getString("cbu_cuenta_origen"));
                transaccion.setErrorDuranteTransaccion(rs.getString("error_durante_transaccion"));
                return transaccion;
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
            return java.util.Collections.emptyList();
        }
    }
}
