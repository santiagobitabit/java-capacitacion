package com.bitabit.banco.infra.out;

import com.bitabit.banco.domain.Cliente;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ClientePortOut {
    public void save(Cliente cliente);
    public Cliente getById(@RequestParam int id);
    public List<Cliente> getAll();
    public void deleteById(int id);
    public Cliente update(int id, Cliente cliente);
}