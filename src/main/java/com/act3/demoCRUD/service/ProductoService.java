package com.act3.demoCRUD.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.act3.demoCRUD.model.Categoria;
import com.act3.demoCRUD.model.Producto;
import com.act3.demoCRUD.repository.CategoriaRepository;
import com.act3.demoCRUD.repository.ProductoRepository;

// @service le dice a spring que esta clase es la capa de logica de negocio
// aqui va lo que hace la aplicacion, y el controller solo la llama
@Service
public class ProductoService {

    // los dos repositorios que necesita el service para trabajar con la bd
    private final ProductoRepository productoRepo;
    private final CategoriaRepository categoriaRepo;

    // inyeccion por constructor: spring me pasa los repositorios ya creados
    // asi no tengo que hacer "new" yo mismo
    public ProductoService(ProductoRepository productoRepo, CategoriaRepository categoriaRepo) {
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
    }

    // read: trae todos los productos de la bd
    public List<Producto> listar() {
        return productoRepo.findAll();
    }

    // read: busca un producto por su id, si no existe lanza error
    public Producto buscar(Long id) {
        return productoRepo.findById(id).orElseThrow();
    }

    // create y update: save inserta si el id es nuevo y actualiza si ya existe
    public Producto guardar(Producto p) {
        return productoRepo.save(p);
    }

    // delete: borra el producto por su id
    public void eliminar(Long id) {
        productoRepo.deleteById(id);
    }

    // trae las categorias para llenar el select del formulario
    public List<Categoria> listarCategorias() {
        return categoriaRepo.findAll();
    }

    // guarda una categoria nueva
    public Categoria guardarCategoria(Categoria c) {
        return categoriaRepo.save(c);
    }
}