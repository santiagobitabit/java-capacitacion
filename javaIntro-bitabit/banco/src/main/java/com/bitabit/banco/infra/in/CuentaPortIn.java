package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.model.Cuenta;
import com.bitabit.banco.domain.model.NuevaCuentaAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CuentaPortIn {
    ResponseEntity<String> newCuenta(NuevaCuentaAPI nuevaCuentaAPI);
    ResponseEntity<String> updateCuentaById(int id, Cuenta cuenta);
    ResponseEntity<Cuenta> getCuentaByCBU(String cbu);
    ResponseEntity<List<Cuenta>> getAllCuentasByClienteId(int clienteId);
}