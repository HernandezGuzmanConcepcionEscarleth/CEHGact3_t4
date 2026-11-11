package com.act3.demoCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.act3.demoCRUD.model.Categoria;
import com.act3.demoCRUD.model.Producto;
import com.act3.demoCRUD.service.ProductoService;

// @controller recibe las peticiones del navegador y devuelve una vista html
// @requestmapping hace que todas las rutas empiecen con /productos
@Controller
@RequestMapping("/productos")
public class ProductoController {

    // el controller no usa el repository directo, usa el service
    private final ProductoService service;

    // spring inyecta el service por constructor
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // read: muestra la tabla con todos los productos
    // model lleva los datos del controller a la vista productos.html
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", service.listar());
        return "productos";
    }

    // create (paso 1): abre el formulario vacio
    // mando tambien las categorias para el select
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", service.listarCategorias());
        return "form";
    }

    // create y update (paso 2): recibe el formulario y lo guarda
    // despues redirige a la lista para ver el cambio
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {

        // busca la categoria seleccionada en la base de datos
        if (producto.getCategoria() != null &&
            producto.getCategoria().getId() != null) {

            Categoria categoria = service.buscarCategoria(
                producto.getCategoria().getId()
            );
            producto.setCategoria(categoria);

        } else {
            // si no eligio categoria, evita guardar un objeto vacio
            producto.setCategoria(null);
        }

        service.guardar(producto);
        return "redirect:/productos";
    }

    // update (paso 1): abre el formulario con los datos del producto
    // @pathvariable toma el id que viene en la url
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", service.buscar(id));
        model.addAttribute("categorias", service.listarCategorias());
        return "form";
    }

    // delete: borra el producto y regresa a la lista
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/productos";
    }
}