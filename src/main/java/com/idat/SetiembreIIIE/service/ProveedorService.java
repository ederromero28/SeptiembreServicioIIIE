package com.idat.SetiembreIIIE.service;

import java.util.List;

import com.idat.SetiembreIIIE.model.Proveedor;

public interface ProveedorService {
    
    void guardar(Proveedor proveedor);
    void actualizar(Proveedor proveedor);
    void eliminar(Integer id);
    List<Proveedor> listar();
    Proveedor obtener(Integer id);

}
