package co.edu.unicartagena.webspring.controllers;

import co.edu.unicartagena.webspring.models.Persona;
import co.edu.unicartagena.webspring.services.persona.IPersonaService;
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
public class PersonaController {

    @Autowired
    IPersonaService personaService;
    
    @GetMapping("/personas/lista")
    public String personaListar(Model model) {
        List<Persona> listaPersonas = personaService.listarPersonas();
        model.addAttribute("persona", listaPersonas);
        return "persona/listaPersona";
    }
    
    @GetMapping("/personas/agregar")
    public String agregar(Persona per) {
        return "persona/modPersonas";
    }
    
    @PostMapping("/personas/guardar")
    public String guardar(@ModelAttribute("persona") @Valid Persona per, Errors errors) {
        if (errors.hasErrors()) {
            return "persona/modPersonas";
        }
        personaService.guardar(per);
        return "redirect:/personas/lista";
    }
    
    @GetMapping("/personas/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Persona per = new Persona();
        per.setId(id);
        per = personaService.buscar(per);
        if (per != null) {
            model.addAttribute("persona", per);
        } else {
            model.addAttribute("error", "Persona no encontrada");
        }
        return "persona/modPersonas";
    }
    
    @GetMapping("/personas/eliminar")
    public String eliminar(Persona per) {
        personaService.eliminiar(per);
        return "redirect:/personas/lista";
    }
    
}

