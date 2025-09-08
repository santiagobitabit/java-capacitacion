package org.bitabit.exceptions;

public class EmpleadoFueraDeRangoEtario extends RuntimeException {
    public EmpleadoFueraDeRangoEtario() {}

    public EmpleadoFueraDeRangoEtario(String message) {
        super(message);
    }

    public EmpleadoFueraDeRangoEtario(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpleadoFueraDeRangoEtario(Throwable cause) {
        super(cause);
    }
}
