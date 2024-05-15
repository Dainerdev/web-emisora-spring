
package co.edu.unicartagena.webspring.services.emisora;

import co.edu.unicartagena.webspring.models.Emisora;
import java.util.List;

public interface IEmisoraService {
    
    public List<Emisora> listarEmisoras();
    
    public void guardar(Emisora emi);
    
    public void eliminiar(Emisora emi);
    
    public Emisora buscar (Emisora emi);
    
}
