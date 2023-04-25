
package com.DelaCasa.controller;

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
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

   
    
        @GetMapping("/mostrarAdmin")
    public String mostrarComentarioAdmin(Model model) {
        var comentarios = comentarioService.getComentarios();
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("totalComentarios", comentarios.size());
        
 
        return "comentario/mostrarAdmin";

    }

    @GetMapping("/nuevo")
    public String comentarioNuevo(Comentario comentario) {
        return "comentario/modifica";

    }

    @PostMapping("/guardar")
    public String comentarioGuardar(Comentario comentario) {
        comentarioService.save(comentario);
        return "redirect:/comentario/mostrarAdmin";
    }

    @GetMapping("/eliminar/{idComentario}")
    public String comentarioEliminar(Comentario comentario) {
        comentarioService.delete(comentario);
        return "redirect:/comentario/mostrarAdmin";
    }

    @GetMapping("/modificar/{idComentario}")
    public String comentarioModificar(Comentario comentario, Model model) {
        comentario = comentarioService.getComentario(comentario);
        model.addAttribute("comentario",comentario);
        return "comentario/modifica";
    }

}
