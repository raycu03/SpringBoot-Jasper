package com.example.demo.dominio.services;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.demo.dominio.model.Producto;
import com.example.demo.shared.dominio.Codigo;

import net.sf.jasperreports.engine.JRException;

public interface ProductoService {
	
	public void guardar (Producto producto);
		
	public List<Producto> buscarTodos();
	
	public Producto buscarxId (Codigo codigo);
	
	public List<Producto> buscarxIds (List<Codigo> codigos);
	
	public Producto borrar (Codigo codigo);
	
	public Producto actualizar(Producto producto, Codigo codigo);
	
	public String report() throws FileNotFoundException, JRException;
	
	

}
