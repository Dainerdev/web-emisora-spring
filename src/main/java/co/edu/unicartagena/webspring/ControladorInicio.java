
package co.edu.unicartagena.webspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class ControladorInicio {

    @GetMapping("/")
    public String inicio(Model modelo) {
        
        String mensaje = "Saludos desde Spring MVC";
        modelo.addAttribute("mensaje", mensaje);
        
        
        log.info("Ejecutando el controlador Inicio");
        return "index";
        
    }
}
