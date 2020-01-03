package com.example.demo.infraestructure.repository.adapters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dominio.services.ProductoService;
import com.example.demo.exceptions.RegistroNoEncontradoExeception;
import com.example.demo.infraestructure.dto.ProductoDto;
import com.example.demo.infraestructure.mapper.ProductoMapper;
import com.example.demo.infraestructure.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductoAdapter implements ProductoService{
	
	@Autowired
	public ProductoRepository productoRepository;

	@Autowired
	public ProductoMapper productoMapper;

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(productoMapper.dominiodtoapi(producto));
		
	}

	@Override
	public List<Producto> buscarTodos() {
		return productoMapper.dtoDominioapi(productoRepository.findAll());
	}

	@Override
	public Producto buscarxId(Codigo codigo) {
		Producto producto = productoMapper
				.dtoDominioapi(productoRepository.findById(codigo.getCodigo()).orElseThrow(() -> new RegistroNoEncontradoExeception()));

		return producto;
	}

	@Override
	public List<Producto> buscarxIds(List<Codigo> codigos) {
		return productoRepository.findAllById(codigos.stream().map(codigo -> codigo.getCodigo()).collect(Collectors.toList()))
				.stream().map(producto -> productoMapper.dtoDominioapi(producto)).collect(Collectors.toList());
	}

	@Override
	public Producto borrar(Codigo codigo) {
		Producto producto = buscarxId(codigo);
		productoRepository.deleteById(codigo.getCodigo());

		return producto;
	}

	@Override
	public Producto actualizar(Producto producto, Codigo codigo) {
		Producto p = buscarxId(codigo);
		guardar(producto);
		
		return p;
	}

	@Override
	public String report() throws FileNotFoundException, JRException{
		String path = "C:\\Users\\ID_0007\\Downloads";
		List<ProductoDto> productos = productoRepository.findAll();
		File file = ResourceUtils.getFile("src\\main\\resources\\productos.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productos);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\productos.pdf" );
		return "report generated in path : " + path;
	}


}
