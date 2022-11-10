package com.idat.SetiembreIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.SetiembreIIIE.model.Item;
import com.idat.SetiembreIIIE.service.ItemService;

@RestController
@RequestMapping("/item/v1")
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    @RequestMapping(path = "/listar" , method = RequestMethod.GET)
    public ResponseEntity<List<Item>> listar(){
        return new ResponseEntity<List<Item>>(itemService.listar(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<?> guardar(@RequestBody Item item){
        
        itemService.guardar(item);
        return new ResponseEntity<>("¡Item registrado!", HttpStatus.OK);

    }
    
    @RequestMapping(path = "/buscarxid/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        
        Item item = itemService.obtener(id);
        
        if (item != null) {
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Item no encontrado!", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<?> editar(@RequestBody Item item){
        
        Item ite = itemService.obtener(item.getIdItem());
        
        if (ite != null) {
            itemService.actualizar(item);
            
            return new ResponseEntity<>("¡Item actualizado correctamente!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Item no actualizado!", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        
        Item item = itemService.obtener(id);
        
        if (item != null) {
            itemService.eliminar(id);
            return new ResponseEntity<>("¡Item eliminado correctamente!",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Item no se pudo encontrar para eliminar!", HttpStatus.NOT_FOUND);
        }
        
        
    }

}
