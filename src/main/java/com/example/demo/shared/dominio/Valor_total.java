package com.example.demo.shared.dominio;

import com.example.demo.exceptions.NegativoExeception;
import com.example.demo.exceptions.RangoExeception;

public class Valor_total {

	private final Double valor;
	
	public Valor_total( Double valor) {
		this.valor = valor;
		
		if (valor<1) {
			throw new NegativoExeception();
			
		}
		if (valor>9999.0) {
			
			throw new RangoExeception();
		}
		
	}

	public Double getvalor() {
		return valor;
	}
}
