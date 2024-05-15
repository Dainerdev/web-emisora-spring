
package co.edu.unicartagena.webspring.services.productora;

import co.edu.unicartagena.webspring.models.Productora;
import java.util.List;

public interface IProductoraService {
    
    public List<Productora> listarProductoras();
    
    public void guardar(Productora prod);
    
    public void eliminar(Productora prod);
    
    public Productora buscar(Productora prod);
}
