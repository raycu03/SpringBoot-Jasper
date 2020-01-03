package com.example.demo.shared.dominio;

import com.example.demo.exceptions.NegativoExeception;

public class Cantidad {

	private final Integer cantidad;

	public Cantidad(Integer cantidad) {
		
		this.cantidad= cantidad;
		if (cantidad<1) {
			throw new NegativoExeception();
			
		}
		
	
	}

	public Integer getCantidad() {
		return cantidad;
	}
	
	
}
