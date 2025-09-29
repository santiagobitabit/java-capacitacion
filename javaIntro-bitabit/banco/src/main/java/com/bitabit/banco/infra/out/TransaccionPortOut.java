package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.model.Cuenta;
import com.bitabit.banco.domain.model.Transaccion;

import java.util.List;
import java.util.Optional;

public interface TransaccionPortOut {
    public String save(Transaccion transaccion);
    public List<Transaccion> getAllByClienteId(int id_cliente);
}
