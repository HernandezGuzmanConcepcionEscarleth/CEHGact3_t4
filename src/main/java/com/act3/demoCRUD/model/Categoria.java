package com.act3.demoCRUD.model;

import jakarta.persistence.*;
import java.util.List;

// tambien es una entidad, o sea que se convierte en la tabla "categoria"
@Entity
public class Categoria {

    // llave primaria con id autoincrementable, igual que en producto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nombre de la categoria, por ejemplo electronica o hogar
    private String nombre;

    // este es el otro lado de la relacion: una categoria tiene muchos productos (uno a muchos)
    // mappedby = "categoria" significa que la llave foranea ya la maneja el campo "categoria"
    // de la clase producto, por eso aqui no se crea otra columna en la tabla categoria
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    // getters y setters para poder leer y modificar los atributos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
}