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

import com.idat.SetiembreIIIE.model.Cliente;
import com.idat.SetiembreIIIE.service.ClienteService;


@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    
    @RequestMapping(path = "/listar" , method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listar(){
        return new ResponseEntity<List<Cliente>>(clienteService.listar(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<?> guardar(@RequestBody Cliente cliente){
        
        clienteService.guardar(cliente);
        return new ResponseEntity<>("¡Cliente registrado!", HttpStatus.OK);

    }
    
    @RequestMapping(path = "/buscarxid/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        
        Cliente cliente = clienteService.obtener(id);
        
        if (cliente != null) {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Cliente no encontrado!", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<?> editar(@RequestBody Cliente cliente){
        
        Cliente cli = clienteService.obtener(cliente.getIdCliente());
        
        if (cli != null) {
            clienteService.actualizar(cliente);
            
            return new ResponseEntity<>("¡Cliente actualizado correctamente!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Cliente no actualizado!", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        
        Cliente cliente = clienteService.obtener(id);
        
        if (cliente != null) {
            clienteService.eliminar(id);
            return new ResponseEntity<>("¡Cliente eliminado correctamente!",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Cliente no se pudo encontrar para eliminar!", HttpStatus.NOT_FOUND);
        }
  
    }
    
}
