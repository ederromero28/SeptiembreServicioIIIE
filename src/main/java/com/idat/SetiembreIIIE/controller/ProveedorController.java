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

import com.idat.SetiembreIIIE.model.Proveedor;
import com.idat.SetiembreIIIE.service.ProveedorService;

@RestController
@RequestMapping("/proveedor/v1")
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;
    
    @RequestMapping(path = "/listar" , method = RequestMethod.GET)
    public ResponseEntity<List<Proveedor>> listar(){
        return new ResponseEntity<List<Proveedor>>(proveedorService.listar(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<?> guardar(@RequestBody Proveedor proveedor){
        
        proveedorService.guardar(proveedor);
        return new ResponseEntity<>("¡Proveedor registrado!", HttpStatus.OK);

    }
    
    @RequestMapping(path = "/buscarxid/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        
        Proveedor proveedor = proveedorService.obtener(id);
        
        if (proveedor != null) {
            return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Proveedor no encontrado!", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<?> editar(@RequestBody Proveedor proveedor){
        
        Proveedor prove = proveedorService.obtener(proveedor.getIdProveedor());
        
        if (prove != null) {
            proveedorService.actualizar(proveedor);
            
            return new ResponseEntity<>("¡Proveedor actualizado correctamente!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Proveedor no actualizado!", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        
        Proveedor proveedor = proveedorService.obtener(id);
        
        if (proveedor != null) {
            proveedorService.eliminar(id);
            return new ResponseEntity<>("¡Proveedor eliminado correctamente!",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡Proveedor no se pudo encontrar para eliminar!", HttpStatus.NOT_FOUND);
        }
        
        
    }

}
