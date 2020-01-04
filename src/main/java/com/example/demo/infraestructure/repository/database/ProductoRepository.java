package com.example.demo.infraestructure.repository.database;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infraestructure.dto.ProductoDto;

public interface ProductoRepository extends JpaRepository<ProductoDto, String>{



}
