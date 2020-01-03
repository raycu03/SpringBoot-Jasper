package com.example.demo.infraestructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.model.Factura;
import com.example.demo.infraestructure.dto.FacturaDto;
import com.example.demo.infraestructure.dto.FacturaRest;
import com.example.demo.infraestructure.dto.ItemDto;
import com.example.demo.infraestructure.dto.ItemRest;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor_total;
import com.example.demo.shared.infraestructure.MapperApiRest;
import com.example.demo.shared.infraestructure.MapperRepository;

@Component
public class FacturaMapper implements MapperApiRest<Factura, FacturaRest>, MapperRepository<Factura, FacturaDto>{

	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public Factura dtoDominio(FacturaDto o) {
		return Factura.of(new Id(o.getNumero()), new Nombre(o.getNombre()), new Valor_total(o.getValor_total()), 
				itemMapper.dtoDominio(o.getItems()));

	}

	@Override
	public FacturaDto dominiodto(Factura i) {
		return new FacturaDto(i.getNumero().getId(), i.getNombre().getNombre(), i.getValor_total().getvalor(),
				itemMapper.dominiodto(i.getItems()));
	}

	@Override
	public Factura dtoDominioapi(FacturaRest o) {
		return Factura.of(new Id(o.getNumero()), new Nombre(o.getNombre()), new Valor_total(o.getValor_total()), 
				itemMapper.dtoDominioapi(o.getItems()));
	}

	@Override
	public FacturaRest dominiodtoapi(Factura i) {
		return new FacturaRest(i.getNumero().getId(), i.getNombre().getNombre(), i.getValor_total().getvalor(),
				itemMapper.dominiodtoapi(i.getItems()));
	}

}
