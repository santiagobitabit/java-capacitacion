package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientePortIn {
    ResponseEntity<Cliente> newCliente(Cliente cliente);
    ResponseEntity<Cliente> getClienteById(int id);
    ResponseEntity<List<Cliente>> getAllClientes();
    ResponseEntity<Object> deleteClienteById(int id);
    ResponseEntity<Cliente> updateClienteById(int id, Cliente cliente);
}