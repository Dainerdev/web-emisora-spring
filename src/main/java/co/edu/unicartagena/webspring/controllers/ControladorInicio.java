package co.edu.unicartagena.webspring.controllers;

import co.edu.unicartagena.webspring.models.Emisora;
import co.edu.unicartagena.webspring.services.IEmisoraService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    IEmisoraService emisoraService;

    @GetMapping("/")
    public String inicio(Model model) {
        List<Emisora> listaEmisoras = emisoraService.listarEmisoras();
        model.addAttribute("emisoras", listaEmisoras);

        log.info("Ejecutando el controlador Inicio");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Emisora emi) {
        return "modify";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("emisora") Emisora emi) {
        emisoraService.guardar(emi);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
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
        return "modify";
    }

    @GetMapping("/eliminar")
    public String eliminar(Emisora emi) {
        emisoraService.eliminiar(emi);
        return "redirect:/";
    }

}
