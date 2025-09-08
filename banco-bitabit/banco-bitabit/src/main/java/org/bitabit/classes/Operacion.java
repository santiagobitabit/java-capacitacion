package org.bitabit.classes;

public abstract class Operacion {
    protected   int monto;
    protected Cuenta origen;

    public Operacion(int monto, Cuenta origen){
        this.monto = monto;
        this.origen = origen;
    }

    @Override
    public boolean equals(Object o){
        return this.monto == ((Operacion)o).monto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    public Cuenta getOrigen() {
        return origen;
    }

    public void setOrigen(Cuenta origen) {
        this.origen = origen;
    }

    public boolean isValid() {
        return origen.getSaldo() > 0 && origen.getSaldo() >= monto && monto > 0;
    }

}
