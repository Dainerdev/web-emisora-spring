
package co.edu.unicartagena.webspring.services.productora;

import co.edu.unicartagena.webspring.crud.IProductoraCrud;
import co.edu.unicartagena.webspring.models.Productora;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoraServiceImp implements IProductoraService{

    @Autowired
    IProductoraCrud crudProductora;
    
    @Transactional(readOnly = true)
    @Override
    public List<Productora> listarProductoras() {
        return (List<Productora>) crudProductora.findAll();
    }

    @Transactional
    @Override
    public void guardar(Productora prod) {
        crudProductora.save(prod);
    }

    @Transactional
    @Override
    public void eliminar(Productora prod) {
        crudProductora.delete(prod);
    }

    @Transactional(readOnly = true)
    @Override
    public Productora buscar(Productora prod) {
        return crudProductora.findById(prod.getId()).orElse(null);
    }

    
}
