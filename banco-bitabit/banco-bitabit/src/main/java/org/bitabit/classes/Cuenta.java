package org.bitabit.classes;

import org.bitabit.enums.Moneda;

public class Cuenta {
    int id;
    Cliente cliente;
    int saldo;
    Moneda moneda;


    public Cuenta (int id,Cliente cliente, Moneda moneda){
        this.id = id;
        this.cliente = cliente;
        this.saldo = 0;
        this.moneda = moneda;
        cliente.addCuenta(this);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getSaldo() {
        return saldo;
     }

     public void setSaldo(int saldo) {
         this.saldo = saldo;
     }

     public Moneda getMoneda() {
        return moneda;
     }

     public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
     }

     public void addSaldo(int saldo) {
        this.saldo += saldo;
     }

     public void subSaldo(int saldo) {
        this.saldo -= saldo;
     }

     public boolean compareTo(Cuenta cuenta) {
        return cuenta.getId() == this.id;
     }
}
