package com.example.demo.infraestructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.model.Item;
import com.example.demo.dominio.model.Producto;
import com.example.demo.infraestructure.dto.ItemDto;
import com.example.demo.infraestructure.dto.ItemRest;
import com.example.demo.infraestructure.dto.ProductoDto;
import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor_total;
import com.example.demo.shared.infraestructure.MapperApiRest;
import com.example.demo.shared.infraestructure.MapperRepository;


@Component
public class ItemMapper implements MapperRepository<Item, ItemDto>, MapperApiRest<Item, ItemRest>{

	@Autowired
	private ProductoMapper productoMapper;
	
	@Override
	public Item dtoDominio(ItemDto o) {
		return Item.of(new Id(o.getId()), new Cantidad(o.getCantidad()),new Valor_total(o.getValar_total()),
				productoMapper.dtoDominioapi(o.getProductoDto()));

	}

	@Override
	public ItemDto dominiodto(Item i) {
		return new ItemDto(i.getId().getId(), i.getCantidad().getCantidad(), i.getValor_total().getvalor(),
				productoMapper.dominiodtoapi(i.getProducto()));

	}
	@Override
	public Item dtoDominioapi(ItemRest o) {
		
		return Item.of(new Id(o.getId()), new Cantidad(o.getCantidad()), new Valor_total(o.getValor_total()),
				productoMapper.dtoDominio(o.getProducto()));

	}

	@Override
	public ItemRest dominiodtoapi(Item i) {
		return new ItemRest(i.getId().getId(), i.getCantidad().getCantidad(), i.getValor_total().getvalor(),
				productoMapper.dominiodto(i.getProducto()));

	}



}