package com.bitabit.banco.domain.model;


import com.bitabit.banco.infra.out.CuentaAdaptatorOut;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class Transaccion {
    private CuentaAdaptatorOut cuentaAdaptatorOut;
    private int id;
    private int id_cliente;
    private double monto;
    private LocalDateTime fecha;
    private String cbuCuentaDestino;
    private String cbuCuentaOrigen;
    private String errorDuranteTransaccion;


    public Transaccion(CuentaAdaptatorOut cuentaAdaptatorOut) {
        this.cuentaAdaptatorOut = cuentaAdaptatorOut;
    }


    public String Deposito(String cbuCuentaDestino, double monto) {
        try {
            Cuenta cuentaDestino = cuentaAdaptatorOut.getByCBU(cbuCuentaDestino).orElse(null);
            if (cuentaDestino == null) {
                return "Cuenta destino no encontrada";
            }
            if (monto <= 0) {
                return "El monto debe ser mayor a cero";
            }
            this.id_cliente = cuentaDestino.getId_cliente();
            this.monto = monto;
            this.fecha = LocalDateTime.now();;
            this.cbuCuentaDestino = cbuCuentaDestino;
            this.cbuCuentaOrigen = "";
            this.errorDuranteTransaccion = "";
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
            cuentaAdaptatorOut.update(cuentaDestino.getId(), cuentaDestino);
            return "Depósito realizado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            this.errorDuranteTransaccion = "ERROR";
            return "Depósito fallido";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getCbuCuentaDestino() {
        return cbuCuentaDestino;
    }

    public void setCbuCuentaDestino(String cbuCuentaDestino) {
        this.cbuCuentaDestino = cbuCuentaDestino;
    }

    public String getCbuCuentaOrigen() {
        return this.cbuCuentaOrigen;
    }

    public void setCbuCuentaOrigen(String cbuCuentaOrigen) {
        this.cbuCuentaOrigen = cbuCuentaOrigen;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getErrorDuranteTransaccion() {
        return errorDuranteTransaccion;
    }

    public void setErrorDuranteTransaccion(String errorDuranteTransaccion) {
        this.errorDuranteTransaccion = errorDuranteTransaccion;
    }
}