package com.example.demo.dominio.model;

import java.util.List;

import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor_total;

public class Factura {

	private final Id numero;
	private final Nombre nombre;
	private final Valor_total valor_total;
	private final List<Item> items;
	
	public Factura(Id numero, Nombre nombre, Valor_total valor_total, List<Item> items) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.valor_total = valor_total;
		this.items = items;
	}

	public Id getNumero() {
		return numero;
	}

	public Nombre getNombre() {
		return nombre;
	}

	public Valor_total getValor_total() {
		return valor_total;
	}

	public List<Item> getItems() {
		return items;
	}

	public static Factura of(Id id, Nombre nombre, Valor_total valor_total, List<Item> items) {
		// TODO Auto-generated method stub
		return new Factura(id, nombre, valor_total, items);
	}
	
	
	
}
