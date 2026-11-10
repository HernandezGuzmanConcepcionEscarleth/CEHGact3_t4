package com.act3.demoCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.act3.demoCRUD.model.Categoria;

// mismo funcionamiento que el de producto, pero para la tabla categoria
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}