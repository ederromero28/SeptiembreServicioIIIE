package com.idat.SetiembreIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.saveAndFlush(producto);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto obtener(Integer id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(null);
	}

}
