package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.Cliente;
import com.bitabit.banco.domain.Empleado;
import com.bitabit.banco.infra.out.ClienteAdaptatorOut;
import com.bitabit.banco.infra.out.EmpleadoAdaptadorOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteAdaptatorIn implements ClientePortIn {

    private final ClienteAdaptatorOut clienteAdaptatorOut;
    private final EmpleadoAdaptadorOut empleadoAdaptadorOut;

    public ClienteAdaptatorIn(ClienteAdaptatorOut clienteAdaptatorOut, EmpleadoAdaptadorOut empleadoAdaptadorOut) {
        this.clienteAdaptatorOut = clienteAdaptatorOut;
        this.empleadoAdaptadorOut = empleadoAdaptadorOut;
    }

    @Override
    @PostMapping("/nuevo")
    public ResponseEntity<String> newCliente(@RequestBody Cliente cliente) {
        String result = clienteAdaptatorOut.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getClienteById(@PathVariable int id) {
         Optional<Cliente> cliente = clienteAdaptatorOut.getById(id);
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
    public ResponseEntity<String> updateClienteById(@PathVariable int id, @RequestBody Cliente cliente) {
        String result = clienteAdaptatorOut.update(id, cliente);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/empleado")
    public Optional<Empleado> obtenerEmpleadoByClienteId(@RequestParam int id) {
        Optional<Cliente> cliente = clienteAdaptatorOut.getById(id);
        if (cliente.isPresent()) {
            int idEmpleado = cliente.get().getId_empleado();
            Optional<Empleado> empleado = empleadoAdaptadorOut.getById(idEmpleado);
            return empleado;
        } else {
            return Optional.empty();
        }
    }
}