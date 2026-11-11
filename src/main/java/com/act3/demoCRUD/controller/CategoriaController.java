package com.act3.demoCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.act3.demoCRUD.model.Categoria;
import com.act3.demoCRUD.service.ProductoService;

// @controller recibe las peticiones del navegador y devuelve una vista html
// @requestmapping hace que todas las rutas empiecen con /categorias
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    // usa el mismo service que ya tiene los metodos de categoria
    private final ProductoService service;

    // spring inyecta el service por constructor
    public CategoriaController(ProductoService service) {
        this.service = service;
    }

    // read: muestra la lista de categorias y el formulario para crear una
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", service.listarCategorias());
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    // create: guarda una categoria nueva y regresa a la lista
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Categoria categoria) {
        service.guardarCategoria(categoria);
        return "redirect:/categorias";
    }
}