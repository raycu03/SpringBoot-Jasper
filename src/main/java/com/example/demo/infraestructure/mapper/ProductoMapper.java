package com.example.demo.infraestructure.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dominio.model.Producto;
import com.example.demo.infraestructure.dto.ProductoDto;
import com.example.demo.infraestructure.dto.ProductoRest;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor_total;
import com.example.demo.shared.infraestructure.MapperApiRest;
import com.example.demo.shared.infraestructure.MapperRepository;

@Component
public class ProductoMapper implements MapperApiRest<Producto, ProductoDto>, MapperRepository<Producto, ProductoRest>{

	public Producto dtoDominioapi(ProductoDto o) {
		return Producto.of( new Codigo(o.getCodigo()), new Nombre(o.getNombre()),
				new Valor_total(o.getValor()));

	}

	public ProductoDto dominiodtoapi(Producto i) {
		ProductoDto pd = new ProductoDto();
		pd.setCodigo(i.getCodigo().getCodigo());
		pd.setNombre(i.getNombre().getNombre());
		pd.setValor(i.getValor().getvalor());
		return pd;
	}

	@Override
	public Producto dtoDominio(ProductoRest o) {
		// TODO Auto-generated method stub

		return Producto.of( new Codigo(o.getCodigo()), new Nombre(o.getNombre()),
				new Valor_total(o.getValor()));
	}

	@Override
	public ProductoRest dominiodto(Producto i) {
		ProductoRest pd = new ProductoRest();
		pd.setCodigo(i.getCodigo().getCodigo());
		pd.setNombre(i.getNombre().getNombre());
		pd.setValor(i.getValor().getvalor());
		return pd;
	}
	
}
