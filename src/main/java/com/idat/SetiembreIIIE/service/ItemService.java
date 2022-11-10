package com.idat.SetiembreIIIE.service;

import java.util.List;

import com.idat.SetiembreIIIE.model.Item;

public interface ItemService {
    
    void guardar(Item item);
    void actualizar(Item item);
    void eliminar(Integer id);
    List<Item> listar();
    Item obtener(Integer id);

}
