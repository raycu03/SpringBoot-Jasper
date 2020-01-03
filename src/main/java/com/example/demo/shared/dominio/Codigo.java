package com.example.demo.shared.dominio;

import com.example.demo.exceptions.CaracteresExeception;

public class Codigo {
	
	private final String codigo;

	public Codigo(String codigo) {
	
		this.codigo = codigo;
		if ( codigo.length() >1000) {
			
			throw new CaracteresExeception();
		}
	}

	public String getCodigo() {
		return codigo;
	}

}
