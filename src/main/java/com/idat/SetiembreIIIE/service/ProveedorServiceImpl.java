package com.idat.SetiembreIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Proveedor;
import com.idat.SetiembreIIIE.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public void guardar(Proveedor proveedor) {
        // TODO Auto-generated method stub
        proveedorRepository.save(proveedor);
    }

    @Override
    public void actualizar(Proveedor proveedor) {
        // TODO Auto-generated method stub
        proveedorRepository.saveAndFlush(proveedor);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        proveedorRepository.deleteById(id);
    }

    @Override
    public List<Proveedor> listar() {
        // TODO Auto-generated method stub
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor obtener(Integer id) {
        // TODO Auto-generated method stub
        return proveedorRepository.findById(id).orElse(null);
    }

}
