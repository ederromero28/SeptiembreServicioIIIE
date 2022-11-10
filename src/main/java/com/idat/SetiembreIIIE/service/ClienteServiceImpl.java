package com.idat.SetiembreIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Cliente;
import com.idat.SetiembreIIIE.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void guardar(Cliente cliente) {
        // TODO Auto-generated method stub
        clienteRepository.save(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        // TODO Auto-generated method stub
        clienteRepository.saveAndFlush(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> listar() {
        // TODO Auto-generated method stub
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtener(Integer id) {
        // TODO Auto-generated method stub
        return clienteRepository.findById(id).orElse(null);
    }

}
