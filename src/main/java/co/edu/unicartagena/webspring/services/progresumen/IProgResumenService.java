
package co.edu.unicartagena.webspring.services.progresumen;

import co.edu.unicartagena.webspring.models.ProgResumen;
import java.util.List;

public interface IProgResumenService {
    
    public List<ProgResumen> listarProgResumen();
    
    public void guardar(ProgResumen progres);
    
    public void eliminar(ProgResumen progres);
    
    public ProgResumen buscar(ProgResumen progres);
}
