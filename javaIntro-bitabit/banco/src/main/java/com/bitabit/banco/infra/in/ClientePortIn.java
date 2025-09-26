package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.Cliente;
import com.bitabit.banco.domain.Empleado;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ClientePortIn {
    ResponseEntity<String> newCliente(Cliente cliente);
    ResponseEntity<Optional<Cliente>> getClienteById(int id);
    ResponseEntity<List<Cliente>> getAllClientes();
    ResponseEntity<Object> deleteClienteById(int id);
    ResponseEntity<String> updateClienteById(int id, Cliente cliente);
}