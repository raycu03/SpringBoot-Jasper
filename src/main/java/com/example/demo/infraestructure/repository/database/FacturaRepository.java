package com.example.demo.infraestructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infraestructure.dto.FacturaDto;

public interface FacturaRepository extends JpaRepository<FacturaDto, Long>{

}
