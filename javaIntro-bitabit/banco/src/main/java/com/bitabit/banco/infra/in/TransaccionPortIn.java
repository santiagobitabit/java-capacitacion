package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.model.NuevoDepositoAPI;

public interface TransaccionPortIn {
    public String realizarDeposito(NuevoDepositoAPI nuevoDepositoAPI);
}
