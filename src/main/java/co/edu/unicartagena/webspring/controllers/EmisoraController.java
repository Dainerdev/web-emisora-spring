package co.edu.unicartagena.webspring.controllers;

import co.edu.unicartagena.webspring.models.Emisora;
import co.edu.unicartagena.webspring.services.emisora.IEmisoraService;
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
public class EmisoraController {

    @Autowired
    IEmisoraService emisoraService;

    @GetMapping("/emisoras/lista")
    public String emisorasListar(Model model) {
        List<Emisora> listaEmisoras = emisoraService.listarEmisoras();
        model.addAttribute("emisora", listaEmisoras);
        return "emisora/listaEmisora";
    }

    @GetMapping("/emisoras/agregar")
    public String agregar(Emisora emi) {
        return "emisora/modEmisoras";
    }

    @PostMapping("/emisoras/guardar")
    public String guardar(@ModelAttribute("emisora") @Valid Emisora emi, Errors errors) {
        if (errors.hasErrors()) {
            return "emisora/modEmisoras";
        }
        emisoraService.guardar(emi);
        return "redirect:/emisoras/lista";
    }

    @GetMapping("/emisoras/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        log.info("Invocando el metodo Editar");
        Emisora emi = new Emisora();
        emi.setId(id);
        emi = emisoraService.buscar(emi);
        if (emi != null) {
            model.addAttribute("emisora", emi);
        } else {
            model.addAttribute("error", "Emisora no encontrada");
        }
        return "emisora/modEmisoras";
    }

    @GetMapping("/emisoras/eliminar")
    public String eliminar(Emisora emi) {
        emisoraService.eliminiar(emi);
        return "redirect:/emisoras/lista";
    }

}
