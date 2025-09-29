package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.model.Cuenta;
import com.bitabit.banco.domain.model.NuevaCuentaAPI;
import com.bitabit.banco.infra.out.CuentaAdaptatorOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaAdaptatorIn implements CuentaPortIn {

    private final CuentaAdaptatorOut cuentaAdaptatorOut;

    public CuentaAdaptatorIn(CuentaAdaptatorOut cuentaAdaptatorOut) {
        this.cuentaAdaptatorOut = cuentaAdaptatorOut;
    }

    @Override
    @PostMapping("/nueva")
    public ResponseEntity<String> newCuenta(@RequestBody NuevaCuentaAPI nuevaCuentaAPI) {
        String result = cuentaAdaptatorOut.save(new Cuenta(nuevaCuentaAPI.getTipoCuenta(), nuevaCuentaAPI.getMoneda(), nuevaCuentaAPI.getId_cliente()));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Override
    @GetMapping("/cbu/{cbu}")
    public ResponseEntity<Cuenta> getCuentaByCBU(@PathVariable String cbu) {
        Optional<Cuenta> cuenta = cuentaAdaptatorOut.getByCBU(cbu);
        return cuenta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> updateCuentaById(@PathVariable int id, @RequestBody Cuenta cuenta) {
        String result = cuentaAdaptatorOut.update(id, cuenta);
        return ResponseEntity.ok().body(result);
    }

    @Override
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Cuenta>> getAllCuentasByClienteId(@PathVariable int clienteId) {
        List<Cuenta> cuentas = cuentaAdaptatorOut.getAllByClienteId(clienteId);
        return ResponseEntity.ok(cuentas);
    }
}
