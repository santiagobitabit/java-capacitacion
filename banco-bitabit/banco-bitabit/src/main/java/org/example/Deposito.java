package org.example;

public class Deposito extends Operacion {
    Empleado empleado;
    Cuenta cuenta;
    int monto;
    public Deposito(int monto, Cuenta origen) {
        super(monto, origen);
        this.monto = monto;
        if (this.isValid()) {
            this.empleado = origen.getEmpleado();
            this.cuenta = origen;
            cuenta.addSaldo(monto);
            empleado.setComision(monto);
            System.out.println("Depósito exitoso");
        } else {
            System.out.println("Error al validar el deposito");
        }
    }

    @Override
    public boolean isValid() {
        return monto > 0;
    }
}

