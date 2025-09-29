package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.model.NuevoDepositoAPI;
import com.bitabit.banco.domain.model.Transaccion;
import com.bitabit.banco.infra.out.TransaccionAdaptatorOut;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionAdaptatorIn implements TransaccionPortIn {

    private TransaccionAdaptatorOut transaccionAdaptatorOut;
    private Transaccion transaccionClass;

    public TransaccionAdaptatorIn(TransaccionAdaptatorOut transaccionAdaptatorOut, Transaccion transaccion) {
        this.transaccionAdaptatorOut = transaccionAdaptatorOut;
        this.transaccionClass = transaccion;
    }


    @Override
    @PostMapping("/deposito")
    public String realizarDeposito(@RequestBody NuevoDepositoAPI nuevoDepositoAPI) {
        String resultado = this.transaccionClass.Deposito(nuevoDepositoAPI.getCbuCuentaDestino(), nuevoDepositoAPI.getMonto());
        String resultadoDB = transaccionAdaptatorOut.save(this.transaccionClass);
        return resultado;
    }
}
