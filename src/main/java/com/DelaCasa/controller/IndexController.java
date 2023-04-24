package com.DelaCasa.controller;

import com.DelaCasa.domain.Receta;
import com.DelaCasa.service.RecetaService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j

public class IndexController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var recetas = recetaService.getRecetas();
        model.addAttribute("recetas", recetas);
        return "index";
        

    }


}
