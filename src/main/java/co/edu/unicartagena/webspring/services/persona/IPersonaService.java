
package co.edu.unicartagena.webspring.services.persona;

import co.edu.unicartagena.webspring.models.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardar(Persona per);
    
    public void eliminiar(Persona per);
    
    public Persona buscar (Persona per);
    
}
