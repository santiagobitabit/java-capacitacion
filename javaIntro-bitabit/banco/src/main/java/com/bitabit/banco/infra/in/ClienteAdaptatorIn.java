package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.Cliente;
import com.bitabit.banco.infra.out.ClienteAdaptatorOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteAdaptatorIn implements ClientePortIn {

    private final ClienteAdaptatorOut clienteAdaptatorOut;

    public ClienteAdaptatorIn(ClienteAdaptatorOut clienteAdaptatorOut) {
        this.clienteAdaptatorOut = clienteAdaptatorOut;
    }

    @Override
    @PostMapping("/nuevo")
    public ResponseEntity<Cliente> newCliente(@RequestBody Cliente cliente) {
        clienteAdaptatorOut.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @Override
    @GetMapping("/:id")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        Cliente cliente = clienteAdaptatorOut.getById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> listaClientes = clienteAdaptatorOut.getAll();
        return ResponseEntity.ok().body(listaClientes);
    }

    @Override
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Object> deleteClienteById(@PathVariable int id) {
        clienteAdaptatorOut.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteAdaptatorOut.update(id, cliente);
        return ResponseEntity.ok().body(clienteActualizado);
    }
}