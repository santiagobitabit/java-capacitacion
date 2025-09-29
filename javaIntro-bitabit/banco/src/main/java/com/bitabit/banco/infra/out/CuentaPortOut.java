package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.model.Cliente;
import com.bitabit.banco.domain.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaPortOut {
    public String save(Cuenta cuenta);
    public Optional<Cuenta> getByCBU(String cbu);
    public List<Cuenta> getAllByClienteId(int id_cliente);
    public void deleteByCBU(String cbu);
}
