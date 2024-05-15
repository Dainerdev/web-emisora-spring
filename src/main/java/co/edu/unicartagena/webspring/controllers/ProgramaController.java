package co.edu.unicartagena.webspring.controllers;

import co.edu.unicartagena.webspring.models.Programa;
import co.edu.unicartagena.webspring.services.programa.IProgramaService;
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
public class ProgramaController {

    @Autowired
    IProgramaService programaService;
    
    @GetMapping("/programas/lista")
    public String programasListar(Model model) {
        List<Programa> listaProgramas = programaService.listarProgramas();
        model.addAttribute("programa", listaProgramas);
        return "programa/listaPrograma";
    }
    
    @GetMapping("/programas/agregar")
    public String agregar(Programa prog) {
        return "programa/modProgramas";
    }
    
    @PostMapping("/programas/guardar")
    public String guardar(@ModelAttribute("programa") @Valid Programa prog, Errors erros) {
        if (erros.hasErrors()) {
            return "programa/modProgramas";
        }
        programaService.guardar(prog);
        return "redirect:/programas/lista";
    }
    
    @GetMapping("/programas/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Programa prog = new Programa();
        prog.setId(id);
        prog = programaService.buscar(prog);
        if (prog != null) {
            model.addAttribute("programa", prog);
        } else {
            model.addAttribute("error", "Programa no encontrado");
        }
        return "programa/modProgramas";
    }
    
    @GetMapping("/programas/eliminar")
    public String eliminar(Programa prog) {
        programaService.eliminiar(prog);
        return "redirect:/programas/lista";
    }
}
