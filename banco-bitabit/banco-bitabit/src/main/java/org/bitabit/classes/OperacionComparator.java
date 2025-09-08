package org.bitabit.classes;

import java.util.Comparator;

public class OperacionComparator implements Comparator<Operacion> {

    @Override
    public int compare(Operacion o1, Operacion o2) {
        return 0;
    }

    public int compareNombreCliente(Operacion o1, Operacion o2) {
        return o1.getOrigen().cliente.nombre.compareTo(o2.origen.cliente.nombre);
    }

    public boolean compareMonto(Operacion o1, Operacion o2) {
        return o1.getMonto() == o2.getMonto();
    }
}
