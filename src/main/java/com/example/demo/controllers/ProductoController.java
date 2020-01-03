package com.example.demo.controllers;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.apliacion.ProductoApplication;
import com.example.demo.dominio.services.ProductoService;
import com.example.demo.infraestructure.dto.ProductoDto;
import com.example.demo.infraestructure.dto.ProductoRest;
import com.example.demo.infraestructure.mapper.ProductoMapper;
import com.example.demo.shared.dominio.Codigo;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	private ProductoApplication productoApplication;
	
	public ProductoController(@Autowired ProductoService productoService,
							@Autowired ProductoMapper productoMapper) {
		this.productoApplication = new ProductoApplication(productoService, productoMapper);
	}

	@PostMapping
	public ProductoRest crear (@RequestBody ProductoRest producto) {
		return productoApplication.crear(producto);
	}

	@GetMapping
	public List<ProductoRest> mostrarTodos () {
		return productoApplication.mostrarTodos();
	}

	@GetMapping("/{codigo}")
	public ProductoRest mostrarUno (@PathVariable String codigo) {
		return productoApplication.buscarUno(codigo);
	}

	@PutMapping("/{codigo}")
	public ProductoRest actualizar (@RequestBody ProductoRest producto, @PathVariable  String codigo) {
		return productoApplication.actualizar(producto, codigo);
	}

	@DeleteMapping("/{codigo}")
	public void eliminar (@PathVariable String codigo) {
		productoApplication.eliminar(codigo);
	}
	
	@GetMapping("/report")
	public String reporte() throws FileNotFoundException, JRException {
		return productoApplication.report();
		
	}
}