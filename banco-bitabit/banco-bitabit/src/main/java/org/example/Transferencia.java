package org.example;

public class Transferencia extends Operacion{
    Cuenta destino;
    Cuenta origen;

    public Transferencia(int monto, Cuenta origen, Cuenta destino) {
        super(monto, origen);
        this.destino = destino;
        this.origen = origen;
        if (this.isValid()) {
            origen.subSaldo(monto);
            destino.addSaldo(monto);
            System.out.println("Transferencia exitosa");
        } else {
            System.out.println("No se puede realizar la transferencia");
        }
    }

    @Override
    public boolean isValid() {
       return super.isValid() && origen.getMoneda().equals(destino.getMoneda()) && !origen.compareTo(destino);
    }
}
