
package co.edu.unicartagena.webspring.services.consorico;

import co.edu.unicartagena.webspring.crud.IConsorcioCrud;
import co.edu.unicartagena.webspring.models.Consorcio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsorcioServiceImp implements IConsorcioService{

    @Autowired
    IConsorcioCrud crudConsorcio;
    
    @Transactional(readOnly = true)
    @Override
    public List<Consorcio> listarConsorcios() {
        return (List<Consorcio>) crudConsorcio.findAll();
    }

    @Transactional
    @Override
    public void guardar(Consorcio cons) {
        crudConsorcio.save(cons);
    }

    @Transactional
    @Override
    public void eliminar(Consorcio cons) {
        crudConsorcio.delete(cons);
    }

    @Transactional(readOnly = true)
    @Override
    public Consorcio buscar(Consorcio cons) {
        return crudConsorcio.findById(cons.getId()).orElse(null);
    }
    
}
