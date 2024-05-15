
package co.edu.unicartagena.webspring.services.programa;

import co.edu.unicartagena.webspring.models.Programa;
import java.util.List;

public interface IProgramaService {
    
    public List<Programa> listarProgramas();
    
    public void guardar(Programa prog);
    
    public void eliminiar(Programa prog);
    
    public Programa buscar (Programa prog);
}
