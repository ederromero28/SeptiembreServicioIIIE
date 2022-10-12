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

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.service.ProductoService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
		
	// SubRecurso (path = "/listar")
	// Nuevo comentario - modo prueba
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> listar(){
		return new ResponseEntity<List<Producto>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Producto producto){
		service.guardar(producto);
		return new ResponseEntity<Void> (HttpStatus.CREATED) ;
	}
	
	@RequestMapping(path = "/buscarxid/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
		
		Producto producto = service.obtener(id);
		
		if (producto != null) {
			return new ResponseEntity<Producto>(producto , HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡PRODUCTO NO ENCONTRADO!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody Producto producto){
		
		Producto p = service.obtener(producto.getIdProducto());
		
		if (p != null) {
			service.actualizar(producto);
			return new ResponseEntity<>("PRODUCTO ACTUALIZADO CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡PRODUCTO NO ACTUALIZADO!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		
		Producto producto = service.obtener(id);
		
		if (producto != null) {
			service.eliminar(id);
			return new ResponseEntity<>("PRODUCTO ELIMINADO CORRECTAMENTE", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡PRODUCTO NO ENCONTRADO PARA ELIMINAR!", HttpStatus.NOT_FOUND);
		}
	}
	
}
