package co.edu.unicartagena.webspring.controllers;

import co.edu.unicartagena.webspring.models.ProgResumen;
import co.edu.unicartagena.webspring.services.progresumen.IProgResumenService;
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
public class ProgResumenController {

    @Autowired
    IProgResumenService progresService;
    
    @GetMapping("/progResumen/lista")
    public String progResumenListar(Model model) {
        List<ProgResumen> listaProgResumen = progresService.listarProgResumen();
        model.addAttribute("progres", listaProgResumen);
        return "progResumen/listaProgResumen";
    }
    
    @GetMapping("/progResumen/agregar")
    public String agregar(ProgResumen progres) {
        return "progResumen/modProgResumen";
    }
    
    @PostMapping("/progResumen/guardar")
    public String guardar(@ModelAttribute("progres") @Valid ProgResumen progres, Errors errors) {
        if (errors.hasErrors()) {
            return "progResumen/modProgResumen";
        }
        progresService.guardar(progres);
        return "redirect:/progResumen/lista";
    }
    
    @GetMapping("/progResumen/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        ProgResumen progres = new ProgResumen();
        progres.setId(id);
        progres = progresService.buscar(progres);
        if (progres != null) {
            model.addAttribute("progres", progres);
        } else {
            model.addAttribute("error", "Programa Resumen no encontrado");
        }
        return "progResumen/modProgResumen";
    }
    
    @GetMapping("/progResumen/eliminar")
    public String eliminar(ProgResumen progres) {
        progresService.eliminar(progres);
        return "redirect:/progResumen/lista";
    }
}
