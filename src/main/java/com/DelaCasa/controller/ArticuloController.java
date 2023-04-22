
package com.DelaCasa.controller;

import com.DelaCasa.domain.Articulo;
import com.DelaCasa.service.ArticuloService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos", articulos.size());
        
 
        return "articulo/listado";

    }

    @GetMapping("/nuevo")
    public String articuloNuevo(Articulo articulo) {
        return "articulo/modifica";

    }

    @PostMapping("/guardar")
    public String articuloGuardar(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/eliminar/{idArticulo}")
    public String articuloEliminar(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/modificar/{idArticulo}")
    public String articuloModificar(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo",articulo);
        return "articulo/modifica";
    }

}
