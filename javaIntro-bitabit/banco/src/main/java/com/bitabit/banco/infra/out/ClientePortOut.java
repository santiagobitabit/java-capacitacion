package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClientePortOut {
    public String save(Cliente cliente);
    public Optional<Cliente> getById(int id);
    public List<Cliente> getAll();
    public void deleteById(int id);
    public String update(int id, Cliente cliente);
}