
package co.edu.unicartagena.webspring.services.consorico;

import co.edu.unicartagena.webspring.models.Consorcio;
import java.util.List;

public interface IConsorcioService {
    
    public List<Consorcio> listarConsorcios();
    
    public void guardar(Consorcio cons);
    
    public void eliminar(Consorcio cons);
    
    public Consorcio buscar(Consorcio cons);
}
