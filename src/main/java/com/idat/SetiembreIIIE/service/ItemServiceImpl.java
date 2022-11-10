package com.idat.SetiembreIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Item;
import com.idat.SetiembreIIIE.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void guardar(Item item) {
        // TODO Auto-generated method stub
        itemRepository.save(item);
    }

    @Override
    public void actualizar(Item item) {
        // TODO Auto-generated method stub
        itemRepository.saveAndFlush(item);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> listar() {
        // TODO Auto-generated method stub
        return itemRepository.findAll();
    }

    @Override
    public Item obtener(Integer id) {
        // TODO Auto-generated method stub
        return itemRepository.findById(id).orElse(null);
    }

}
