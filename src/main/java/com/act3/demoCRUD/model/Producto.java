package com.act3.demoCRUD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// con @entity le digo a spring que esta clase es una tabla de la base de datos
// hibernate la crea sola en mysql con el nombre "producto"
@Entity
public class Producto {

    // @id marca este campo como la llave primaria de la tabla
    // @generatedvalue identity hace que mysql le ponga el numero solo (auto_increment)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // cada atributo normal se convierte en una columna de la tabla
    private String nombre;
    private Double precio;

    // aqui esta la relacion: muchos productos pertenecen a una sola categoria (muchos a uno)
    // @joincolumn crea la llave foranea "categoria_id" en la tabla producto,
    // y esa columna guarda el id de la categoria a la que pertenece
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // getters y setters: sirven para leer y cambiar los atributos,
    // spring y thymeleaf los usan para llenar el formulario y mostrar los datos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}