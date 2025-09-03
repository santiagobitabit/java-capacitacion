package org.example;

public class Cuenta {
    int id;
    Cliente cliente;
    Empleado empleado;
    int saldo;
    String moneda;


    Cuenta (int id,Cliente cliente, Empleado empleado, String moneda){
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.saldo = 0;
        this.moneda = moneda;
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

     public Empleado getEmpleado() {
        return empleado;
     }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getSaldo() {
        return saldo;
     }

     public void setSaldo(int saldo) {
         this.saldo = saldo;
     }

     public String getMoneda() {
        return moneda;
     }

     public void setMoneda(String moneda) {
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
