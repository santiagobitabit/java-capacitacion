package org.example;

public class Extraccion extends Operacion{

    public Extraccion(int monto, Cuenta origen) {
        super(monto, origen);
        if (super.isValid()) {
            origen.subSaldo(monto);
            Empleado empleado = origen.getEmpleado();
            empleado.setComision(monto);
            System.out.println("Extracción exitosa");
        } else {
            System.out.println("No se puede realizar el extraccion");
        }
    }
}
