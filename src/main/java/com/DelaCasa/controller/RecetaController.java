

package com.DelaCasa.controller;

import com.DelaCasa.domain.Receta;
import com.DelaCasa.service.RecetaService;
import com.DelaCasa.domain.Comentario;
import com.DelaCasa.service.ComentarioService;
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
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private ComentarioService comentarioService;
    @Autowired
    private RecetaService recetaService;

    
        @GetMapping("/mostrarAdmin")
    public String mostrarRecetaAdmin(Model model) {
        var recetas = recetaService.getRecetas();
        model.addAttribute("recetas", recetas);
        model.addAttribute("totalRecetas", recetas.size());
        
 
        return "receta/mostrarAdmin";

    }

    @GetMapping("/nuevo")
    public String recetaNuevo(Receta receta) {
        return "receta/modifica";

    }

    @PostMapping("/guardar")
    public String recetaGuardar(Receta receta) {
        recetaService.save(receta);
        return "redirect:/receta/mostrarAdmin";
    }

    @GetMapping("/eliminar/{idReceta}")
    public String recetaEliminar(Receta receta) {
        recetaService.delete(receta);
        return "redirect:/receta/mostrarAdmin";
    }

    @GetMapping("/modificar/{idReceta}")
    public String recetaModificar(Receta receta, Model model) {
        receta = recetaService.getReceta(receta);
        model.addAttribute("receta",receta);
        return "receta/modifica";
    }
     @GetMapping("/mostrar/{idReceta}")
    public String mostrarReceta(Receta receta, Model model) {
        var comentarios = comentarioService.getComentarios();
        model.addAttribute("comentarios", comentarios);
        receta = recetaService.getReceta(receta);
        model.addAttribute("receta", receta);
        return "receta/mostrar";
    }
}
