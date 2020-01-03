package com.example.demo.exceptions;

public class NegativoExeception extends RuntimeException{
	
	public NegativoExeception() {
		super("el valor no puede ser negativo ");
	}

}
