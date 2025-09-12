package org.bitabit.classes;

public class Deposito extends Operacion {
    Empleado empleado;
    Cuenta cuenta;
    int monto;
    public Deposito(int monto, Cuenta origen) {
        super(monto, origen);
        this.monto = monto;
        if (this.isValid()) {
            try {
                Thread.sleep(0);
                this.empleado = origen.getCliente().empleado;
                this.cuenta = origen;
                cuenta.addSaldo(monto);
                empleado.setComision(monto);
                System.out.println("Depósito exitoso");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Error al validar el deposito");
        }
    }

    @Override
    public boolean isValid() {
        return monto > 0;
    }
}

