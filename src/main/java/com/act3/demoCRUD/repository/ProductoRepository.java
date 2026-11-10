package com.act3.demoCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.act3.demoCRUD.model.Producto;

// el repository es la capa que habla con la base de datos
// al extender jparepository ya tengo listos findAll, findById, save y deleteById
// sin escribir nada de sql
// los dos tipos son: la entidad (producto) y el tipo de su llave primaria (long)
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}