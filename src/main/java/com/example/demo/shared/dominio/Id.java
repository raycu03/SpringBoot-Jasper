package com.example.demo.shared.dominio;

import com.example.demo.exceptions.RangoExeception;

public class Id {

	private final Long id;
	public Id(Long id) {

		this.id = id;
		if (id<0) {
			
			throw new RangoExeception();
		}
		
		
	}
	public Long getId() {
		return id;
	}
}
