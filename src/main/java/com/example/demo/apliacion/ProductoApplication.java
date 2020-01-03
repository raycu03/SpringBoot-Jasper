package com.example.demo.apliacion;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.demo.dominio.services.ProductoService;
import com.example.demo.infraestructure.dto.ProductoRest;
import com.example.demo.infraestructure.mapper.ProductoMapper;
import com.example.demo.shared.dominio.Codigo;

import net.sf.jasperreports.engine.JRException;

public class ProductoApplication {
	
	private ProductoService productoService;
	private ProductoMapper productoMapper;
	
	public ProductoApplication(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	public ProductoRest crear (ProductoRest producto) {
		productoService.guardar(productoMapper.dtoDominio(producto));
		return producto;
	}
	
	public List<ProductoRest> mostrarTodos () {
		List<ProductoRest> productos = productoMapper.dominiodto(productoService.buscarTodos());

		return productos;
	}
	
	public ProductoRest buscarUno (String codigo) {
		ProductoRest producto = productoMapper.dominiodto(productoService.buscarxId(new Codigo(codigo)));
		return producto;
	}
	
		public void eliminar (String codigo) {
		ProductoRest producto = productoMapper.dominiodto(productoService.borrar(new Codigo(codigo)));
	}
	
	public ProductoRest actualizar (ProductoRest producto, String codigo) {
		ProductoRest encontrado = productoMapper.dominiodto(productoService.actualizar(productoMapper.dtoDominio(producto), new Codigo(codigo)));
		return producto;
	}
	
	public String report() throws FileNotFoundException, JRException {
		String reporte= productoService.report();
		return reporte;
		
	}
	

}
