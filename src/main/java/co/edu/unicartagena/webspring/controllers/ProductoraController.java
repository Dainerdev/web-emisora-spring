package co.edu.unicartagena.webspring.controllers;

import co.edu.unicartagena.webspring.models.Productora;
import co.edu.unicartagena.webspring.services.productora.IProductoraService;
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
public class ProductoraController {

    @Autowired
    IProductoraService productoraService;
    
    @GetMapping("/productoras/lista")
    public String productorasListar(Model model) {
        List<Productora> listaProductoras = productoraService.listarProductoras();
        model.addAttribute("productora", listaProductoras);
        return "productora/listaProductora";
    }
    
    @GetMapping("/productoras/agregar")
    public String agregar(Productora prod) {
        return "productora/modProductoras";
    }
    
    @PostMapping("/productoras/guardar")
    public String guardar(@ModelAttribute("productora") @Valid Productora prod, Errors erros) {
        if (erros.hasErrors()) {
            return "productora/modProductoras";
        }
        productoraService.guardar(prod);
        return "redirect:/productoras/lista";
    }
    
    @GetMapping("/productoras/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Productora prod = new Productora();
        prod.setId(id);
        prod = productoraService.buscar(prod);
        if (prod != null) {
            model.addAttribute("productora", prod);
        } else {
            model.addAttribute("error", "Productora no encontrada");
        }
        return "productora/modProductoras";
    }
    
    @GetMapping("/productoras/eliminar")
    public String eliminar(Productora prod) {
        productoraService.eliminar(prod);
        return "redirect:/productoras/lista";
    }
}
