package com.maye.restaurante_app.controller;

import com.maye.restaurante_app.model.Plato;
import com.maye.restaurante_app.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PlatoService platoService;

    @GetMapping
    public String listarMenu(Model model) {
        model.addAttribute("platos", platoService.listarTodos());
        return "menu/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoPlato(Model model) {
        model.addAttribute("plato", new Plato());
        model.addAttribute("tipos", new String[]{"entrada", "fondo", "postre", "bebida"});
        return "menu/form";
    }

    @PostMapping("/guardar")
    public String guardarPlato(@ModelAttribute Plato plato) {
        platoService.guardar(plato);
        return "redirect:/menu";
    }
}