
package co.edu.unicartagena.webspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @GetMapping("/emisoras")
    public String emisoras() {
        return "emisora/emisoras";
    }
    
    @GetMapping("/productoras")
    public String productoras() {
        return "productora/productoras";
    }
    
    @GetMapping("/consorcios")
    public String consorcios() {
        return "consorcio/consorcios";
    }
    
    @GetMapping("/programas")
    public String programas() {
        return "programa/programas";
    }
    
    @GetMapping("/progResumen")
    public String progResumen() {
        return "progResumen/progResumen";
    }
    
    @GetMapping("/personas")
    public String personas() {
        return "persona/personas";
    }
}
