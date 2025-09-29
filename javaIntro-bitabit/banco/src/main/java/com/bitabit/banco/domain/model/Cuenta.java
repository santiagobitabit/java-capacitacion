package com.bitabit.banco.domain.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class Cuenta {

    private int id;

    private String tipoCuenta;

    private String moneda;

    private String cbu;

    private double saldo;

    private int id_cliente;

    public Cuenta() {}

    public Cuenta(String tipoCuenta, String moneda, int id_cliente) {
        this.tipoCuenta = tipoCuenta;
        this.moneda = moneda;
        this.id_cliente = id_cliente;
        this.cbu = generarCbu();
        this.saldo = 0.0;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static String generarCbu() {
        long timestamp = System.currentTimeMillis();
        long randomNum = ThreadLocalRandom.current().nextLong(100_000_000L, 1_000_000_000L);
        return String.valueOf(timestamp) + String.valueOf(randomNum);
    }
}
