package com.example.demo.shared.infraestructure;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperRepository <I, O>{

	public I dtoDominio(O o);
	public O dominiodto(I i);
	
	public default List<O> dominiodto(List<I> instancias){
		return instancias.stream().map(this::dominiodto).collect(Collectors.toList());
	}
	public default List<I> dtoDominio(List<O> instancias){
		return instancias.stream().map(this::dtoDominio).collect(Collectors.toList());
	}

}
