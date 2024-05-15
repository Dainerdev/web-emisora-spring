package co.edu.unicartagena.webspring.controllers;

import co.edu.unicartagena.webspring.models.Consorcio;
import co.edu.unicartagena.webspring.services.consorico.IConsorcioService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ConsorcioController {

    @Autowired
    IConsorcioService consorcioService;
    
    @GetMapping("/consorcios/lista")
    public String consorciosLista(Model model) {
        List<Consorcio> listaConsorcios = consorcioService.listarConsorcios();
        model.addAttribute("consorcio", listaConsorcios);
        return "consorcio/listaConsorcio";
    }
    
    @GetMapping("/consorcios/agregar")
    public String agregar(Consorcio cons) {
        return "consorcio/modConsorcios";
    }
    
    @PostMapping("/consorcios/guardar")
    public String guardar(@ModelAttribute("consorcio") @Valid Consorcio cons, Errors errors) {
        if (errors.hasErrors()) {
            return "consorcio/modConsorcios";
        }
        consorcioService.guardar(cons);
        return "redirect:/consorcios/lista";
    }
    
    @GetMapping("/consorcios/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Consorcio cons = new Consorcio();
        cons.setId(id);
        cons = consorcioService.buscar(cons);
        if (cons != null) {
            model.addAttribute("consorcio", cons);
        } else {
            model.addAttribute("error", "Consorcio no encontrado");
        }
        return "consorcio/modConsorcios";
    }
    
    @GetMapping("/consorcios/eliminar")
    public String eliminar(Consorcio cons) {
        consorcioService.eliminar(cons);
        return "redirect:/consorcios/lista";
    }    
}
