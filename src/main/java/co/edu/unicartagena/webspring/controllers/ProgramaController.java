package co.edu.unicartagena.webspring.controllers;

import co.edu.unicartagena.webspring.models.Programa;
import co.edu.unicartagena.webspring.services.programa.IProgramaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ProgramaController {

    @Autowired
    IProgramaService programaService;
    
    @GetMapping("/programas/lista")
    public String programa(Model model) {
        List<Programa> listaProgramas = programaService.listarProgramas();
        model.addAttribute("programas", listaProgramas);

        return "listaProgramas";
    }
    
    
    
    
    
}
