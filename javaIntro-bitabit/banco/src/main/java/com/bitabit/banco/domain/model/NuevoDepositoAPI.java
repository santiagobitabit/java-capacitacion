package com.bitabit.banco.domain.model;

public class NuevoDepositoAPI {
    String cbuCuentaDestino;
    Double monto;

    public String getCbuCuentaDestino() {
        return cbuCuentaDestino;
    }

    public void setCbuCuentaDestino(String cbuCuentaDestino) {
        this.cbuCuentaDestino = cbuCuentaDestino;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
