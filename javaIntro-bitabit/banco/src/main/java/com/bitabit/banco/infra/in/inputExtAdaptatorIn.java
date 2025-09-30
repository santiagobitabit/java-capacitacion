package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.model.Cliente;
import com.bitabit.banco.infra.out.ClienteAdaptatorOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/input-ext")
public class inputExtAdaptatorIn {

    private final InputClientesExt inputClientesExt;
    private final ClienteAdaptatorOut clienteAdaptatorOut;

    public inputExtAdaptatorIn(InputClientesExt inputClientesExt, ClienteAdaptatorOut clienteAdaptatorOut) {
        this.inputClientesExt = inputClientesExt;
        this.clienteAdaptatorOut = clienteAdaptatorOut;
    }

    @GetMapping("/clientes")
    public ResponseEntity<String> inputClientesExt() {
        // La lambda se ejecutará para cada cliente en el array recibido de la API
        List<Cliente> clientesExternosList = inputClientesExt.someRestCall().collectList().block();

        for (Cliente cliente : clientesExternosList) {
            String result = clienteAdaptatorOut.save(cliente);
            System.out.println(result + " - " + cliente.getApellido());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Clientes externos procesados");
    }
}
