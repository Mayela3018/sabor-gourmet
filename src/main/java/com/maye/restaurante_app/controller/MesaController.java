package com.maye.restaurante_app.controller;

import com.maye.restaurante_app.model.Mesa;
import com.maye.restaurante_app.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public String listarMesas(Model model) {
        model.addAttribute("mesas", mesaService.listarTodas());
        return "mesas/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("mesa", new Mesa());
        return "mesas/form";
    }

    @PostMapping("/guardar")
    public String guardarMesa(@ModelAttribute Mesa mesa, RedirectAttributes flash) {
        try {
            mesaService.guardar(mesa);
            flash.addFlashAttribute("success", "Mesa registrada correctamente");
        } catch (Exception e) {
            flash.addFlashAttribute("error", "Error al registrar la mesa");
        }
        return "redirect:/mesas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Mesa mesa = mesaService.obtenerPorId(id);
        if (mesa == null) {
            return "redirect:/mesas";
        }
        model.addAttribute("mesa", mesa);
        return "mesas/form";
    }

    @PostMapping("/actualizar")
    public String actualizarMesa(@ModelAttribute Mesa mesa, RedirectAttributes flash) {
        try {
            mesaService.guardar(mesa);
            flash.addFlashAttribute("success", "Mesa actualizada correctamente");
        } catch (Exception e) {
            flash.addFlashAttribute("error", "Error al actualizar la mesa");
        }
        return "redirect:/mesas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMesa(@PathVariable Long id, RedirectAttributes flash) {
        try {
            mesaService.eliminar(id);
            flash.addFlashAttribute("success", "Mesa eliminada correctamente");
        } catch (Exception e) {
            flash.addFlashAttribute("error", "Error al eliminar la mesa");
        }
        return "redirect:/mesas";
    }

    @GetMapping("/ocupar/{id}")
    public String ocuparMesa(@PathVariable Long id, RedirectAttributes flash) {
        mesaService.ocuparMesa(id);
        flash.addFlashAttribute("success", "Mesa ocupada");
        return "redirect:/mesas";
    }

    @GetMapping("/liberar/{id}")
    public String liberarMesa(@PathVariable Long id, RedirectAttributes flash) {
        mesaService.liberarMesa(id);
        flash.addFlashAttribute("success", "Mesa liberada");
        return "redirect:/mesas";
    }
}